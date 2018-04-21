package typeinfo.E20;
import static com.q10viking.util.Print.*;

public class E20_ClassDump{
	public static void display(String msg,Object[] vals){
		print(msg);
		for(Object val: vals){
			print(val);
		}
	}

	public static void classInfo(Class<?> c) throws Exception{
		print("c.getName(): "+c.getName());
		print("c.getPackage() "+c.getPackage());
		print("c.getSuperclass(): "+c.getSuperclass());

		//This produces all the classes declared as members:
		display("c.getDeclaredClasses()",c.getDeclaredClasses());

		display("c.getClasses()",c.getClasses());
		display("c.getInterfaces()",c.getInterfaces());

		//The "Declared" version includes all versions,not just public
		display("c.getDeclaredMethods()",c.getDeclaredMethods());
		display("c.getDeclaredConstructors()",c.getDeclaredConstructors());

		display("c.getConstructors()",c.getConstructors());
		display("c.getDeclaredFields()",c.getDeclaredFields());
		display("c.getFields()",c.getFields());

		if(c.getSuperclass() != null){
			print("Base class: ----------");
			classInfo(c.getSuperclass());
		}

		print("End of "+c.getName());
	}

	public static void main(String[] args) throws Exception{
		for(String arg: args)
			classInfo(Class.forName(arg));
	}

}




/*

λ java typeinfo.E20.E20_ClassDump java.util.ArrayList
c.getName(): java.util.ArrayList
c.getPackage() package java.util, Java Platform API Specification, ver
sion 1.8
c.getSuperclass(): class java.util.AbstractList
c.getDeclaredClasses()
class java.util.ArrayList$ArrayListSpliterator
class java.util.ArrayList$Itr
class java.util.ArrayList$ListItr
class java.util.ArrayList$SubList
c.getClasses()
c.getInterfaces()
interface java.util.List
interface java.util.RandomAccess
interface java.lang.Cloneable
interface java.io.Serializable
c.getDeclaredMethods()
public boolean java.util.ArrayList.add(java.lang.Object)
public void java.util.ArrayList.add(int,java.lang.Object)
public boolean java.util.ArrayList.remove(java.lang.Object)
public java.lang.Object java.util.ArrayList.remove(int)
public java.lang.Object java.util.ArrayList.get(int)
public java.lang.Object java.util.ArrayList.clone()
public int java.util.ArrayList.indexOf(java.lang.Object)
public void java.util.ArrayList.clear()
public boolean java.util.ArrayList.contains(java.lang.Object)
public boolean java.util.ArrayList.isEmpty()
public java.util.Iterator java.util.ArrayList.iterator()
public int java.util.ArrayList.lastIndexOf(java.lang.Object)
public void java.util.ArrayList.replaceAll(java.util.function.UnaryOpe
rator)
public int java.util.ArrayList.size()
public java.util.List java.util.ArrayList.subList(int,int)
public java.lang.Object[] java.util.ArrayList.toArray(java.lang.Object
[])
public java.lang.Object[] java.util.ArrayList.toArray()
public java.util.Spliterator java.util.ArrayList.spliterator()
static int java.util.ArrayList.access$100(java.util.ArrayList)
public boolean java.util.ArrayList.addAll(int,java.util.Collection)
public boolean java.util.ArrayList.addAll(java.util.Collection)
private void java.util.ArrayList.readObject(java.io.ObjectInputStream)
 throws java.io.IOException,java.lang.ClassNotFoundException
private void java.util.ArrayList.writeObject(java.io.ObjectOutputStrea
m) throws java.io.IOException
public void java.util.ArrayList.forEach(java.util.function.Consumer)
public java.lang.Object java.util.ArrayList.set(int,java.lang.Object)
public void java.util.ArrayList.ensureCapacity(int)
public void java.util.ArrayList.trimToSize()
private void java.util.ArrayList.ensureCapacityInternal(int)
private static int java.util.ArrayList.hugeCapacity(int)
java.lang.Object java.util.ArrayList.elementData(int)
private void java.util.ArrayList.grow(int)
public java.util.ListIterator java.util.ArrayList.listIterator()
public java.util.ListIterator java.util.ArrayList.listIterator(int)
public boolean java.util.ArrayList.removeAll(java.util.Collection)
public boolean java.util.ArrayList.removeIf(java.util.function.Predica
te)
protected void java.util.ArrayList.removeRange(int,int)
public boolean java.util.ArrayList.retainAll(java.util.Collection)
public void java.util.ArrayList.sort(java.util.Comparator)
private java.lang.String java.util.ArrayList.outOfBoundsMsg(int)
private void java.util.ArrayList.rangeCheckForAdd(int)
private boolean java.util.ArrayList.batchRemove(java.util.Collection,b
oolean)
private void java.util.ArrayList.ensureExplicitCapacity(int)
private void java.util.ArrayList.fastRemove(int)
private void java.util.ArrayList.rangeCheck(int)
static void java.util.ArrayList.subListRangeCheck(int,int,int)
c.getDeclaredConstructors()
public java.util.ArrayList(java.util.Collection)
public java.util.ArrayList()
public java.util.ArrayList(int)
c.getConstructors()
public java.util.ArrayList(java.util.Collection)
public java.util.ArrayList()
public java.util.ArrayList(int)
c.getDeclaredFields()
private static final long java.util.ArrayList.serialVersionUID
private static final int java.util.ArrayList.DEFAULT_CAPACITY
private static final java.lang.Object[] java.util.ArrayList.EMPTY_ELEM
ENTDATA
private static final java.lang.Object[] java.util.ArrayList.DEFAULTCAP
ACITY_EMPTY_ELEMENTDATA
transient java.lang.Object[] java.util.ArrayList.elementData
private int java.util.ArrayList.size
private static final int java.util.ArrayList.MAX_ARRAY_SIZE
c.getFields()
Base class: ----------
c.getName(): java.util.AbstractList
c.getPackage() package java.util, Java Platform API Specification, ver
sion 1.8
c.getSuperclass(): class java.util.AbstractCollection
c.getDeclaredClasses()
class java.util.AbstractList$Itr
class java.util.AbstractList$ListItr
c.getClasses()
c.getInterfaces()
interface java.util.List
c.getDeclaredMethods()
public void java.util.AbstractList.add(int,java.lang.Object)
public boolean java.util.AbstractList.add(java.lang.Object)
public java.lang.Object java.util.AbstractList.remove(int)
public abstract java.lang.Object java.util.AbstractList.get(int)
public boolean java.util.AbstractList.equals(java.lang.Object)
public int java.util.AbstractList.hashCode()
public int java.util.AbstractList.indexOf(java.lang.Object)
public void java.util.AbstractList.clear()
public java.util.Iterator java.util.AbstractList.iterator()
public int java.util.AbstractList.lastIndexOf(java.lang.Object)
public java.util.List java.util.AbstractList.subList(int,int)
public boolean java.util.AbstractList.addAll(int,java.util.Collection)

public java.lang.Object java.util.AbstractList.set(int,java.lang.Objec
t)
public java.util.ListIterator java.util.AbstractList.listIterator(int)

public java.util.ListIterator java.util.AbstractList.listIterator()
protected void java.util.AbstractList.removeRange(int,int)
private java.lang.String java.util.AbstractList.outOfBoundsMsg(int)
private void java.util.AbstractList.rangeCheckForAdd(int)
c.getDeclaredConstructors()
protected java.util.AbstractList()
c.getConstructors()
c.getDeclaredFields()
protected transient int java.util.AbstractList.modCount
c.getFields()
Base class: ----------
c.getName(): java.util.AbstractCollection
c.getPackage() package java.util, Java Platform API Specification, ver
sion 1.8
c.getSuperclass(): class java.lang.Object
c.getDeclaredClasses()
c.getClasses()
c.getInterfaces()
interface java.util.Collection
c.getDeclaredMethods()
public boolean java.util.AbstractCollection.add(java.lang.Object)
public boolean java.util.AbstractCollection.remove(java.lang.Object)
public java.lang.String java.util.AbstractCollection.toString()
public void java.util.AbstractCollection.clear()
public boolean java.util.AbstractCollection.contains(java.lang.Object)

public boolean java.util.AbstractCollection.isEmpty()
public abstract java.util.Iterator java.util.AbstractCollection.iterat
or()
public abstract int java.util.AbstractCollection.size()
public java.lang.Object[] java.util.AbstractCollection.toArray(java.la
ng.Object[])
public java.lang.Object[] java.util.AbstractCollection.toArray()
public boolean java.util.AbstractCollection.addAll(java.util.Collectio
n)
private static int java.util.AbstractCollection.hugeCapacity(int)
public boolean java.util.AbstractCollection.containsAll(java.util.Coll
ection)
public boolean java.util.AbstractCollection.removeAll(java.util.Collec
tion)
public boolean java.util.AbstractCollection.retainAll(java.util.Collec
tion)
private static java.lang.Object[] java.util.AbstractCollection.finishT
oArray(java.lang.Object[],java.util.Iterator)
c.getDeclaredConstructors()
protected java.util.AbstractCollection()
c.getConstructors()
c.getDeclaredFields()
private static final int java.util.AbstractCollection.MAX_ARRAY_SIZE
c.getFields()
Base class: ----------
c.getName(): java.lang.Object
c.getPackage() package java.lang, Java Platform API Specification, ver
sion 1.8
c.getSuperclass(): null
c.getDeclaredClasses()
c.getClasses()
c.getInterfaces()
c.getDeclaredMethods()
protected void java.lang.Object.finalize() throws java.lang.Throwable
public final void java.lang.Object.wait() throws java.lang.Interrupted
Exception
public final void java.lang.Object.wait(long,int) throws java.lang.Int
erruptedException
public final native void java.lang.Object.wait(long) throws java.lang.
InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
protected native java.lang.Object java.lang.Object.clone() throws java
.lang.CloneNotSupportedException
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
private static native void java.lang.Object.registerNatives()
c.getDeclaredConstructors()
public java.lang.Object()
c.getConstructors()
public java.lang.Object()
c.getDeclaredFields()
c.getFields()
End of java.lang.Object
End of java.util.AbstractCollection
End of java.util.AbstractList
End of java.util.ArrayList















*/
