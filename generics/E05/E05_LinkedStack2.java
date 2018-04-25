package generics.E05;
class LinkedStack<T>{
	class Node{
		private T item;
		private Node next;
		public Node(){ item=null;next=null;}
		public Node(T item,Node nextNode){
			this.item = item;
			this.next = nextNode;
		}
		public boolean end(){
			return (item==null)&&(next==null);
		}
	}
	private  Node top = new Node();
	public void push(T item){
		top = new Node(item,top);
	}
	public T pop(){
		if(top.end())
			return null;
		T result = top.item;
		top = top.next;
		return result;
	}
}


public class E05_LinkedStack2{
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		LinkedStack<String> stack = new LinkedStack();
		for(String s: "0 1 2 3 4".split(" "))
			stack.push(s);
		String s;
		while((s=stack.pop())!= null){
			System.out.print(s+" ");
		}
	}	
}

/*
java generics.E05.E05_LinkedStack2
4 3 2 1 0
*/