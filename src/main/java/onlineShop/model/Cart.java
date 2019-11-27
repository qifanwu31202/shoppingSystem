package onlineShop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	private static final long serialVersionUID = 8436097833452420298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//JsonIgnore 用于属性或者方法上，可使序列化过程忽略该属性，生成的 json 不包含此属性
	@OneToOne(mappedBy = "cart")
	@JsonIgnore
	private Customer customer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	//当你删掉购物车的时候 物品肯定没了 反过来也是
	/***FetchType 加载树形结构,使用关闭懒加载fetch=FetchType.EAGER 在数据库中取值的时候，
	 * 如果使用懒加载，就会只取出一层节点的数据，然后关闭session，这样再去取下一层级的数据的时候就会报出错误：
	 * session is closed如果是EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中如果是LAZY，
	 * 那么取出这条数据时，它关联的数据并不取出来，在同一个session中，什么时候要用，就什么时候取(再次访问数据库)。
	 * 但是，在session外，就不能再取了。用EAGER时，因为在内存里，所以在session外也可以取。***/
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartItem> cartItem;
	
	private double totalPrice;


}
