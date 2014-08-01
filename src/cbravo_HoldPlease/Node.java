package cbravo_HoldPlease;

public class Node<T> {
	
	T value_;
	Node<T> child;
	
	
	Node(T value){
		child = null;
		value_=value;
	}
	
	public Node<T> getChild(){
		return child;
		
	}
	
	public T getValue(){
		return value_;
		
	}
	
	public void setValue(T value){
		this.value_ = value;
		
	}
	
	//This Method is only for use by priority queue
	public void addChild(Node<T> child2){
		Node<T> temp = child;
		setChild(child2);
		child2.setChild(temp);
	}
	
	public void setChild(Node<T> child){
		this.child = child;
	}
}
