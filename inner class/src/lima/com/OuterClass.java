package lima.com;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OuterClass {
	
	private static int vStatic;
	
	private int field1 = 1;
	public int field2 = 2;
	
	public int i = 10;
	
	// Inner class anônima
	@SuppressWarnings("unchecked")
	private List<Integer> list = new List() {
		
		// public List() { // erro: no constructor
		// }
		
		class innerClass2 {
			
		}
		
		// public interface test { // erro
		//	
		// }
		
		// private static int varStatic = 30; // erro
		private static final int varStatic = 30;

		private int l = OuterClass.this.field2;
		
		public void newMethod() {
			
		}
		
		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator<Integer> iterator() {
			return null;
		}

		@Override
		public Object[] toArray() {
			return null;
		}

		@Override
		public Object[] toArray(Object[] a) {
			return null;
		}

		@Override
		public boolean add(Object e) {
			return false;
		}

		@Override
		public boolean remove(Object o) {
			return false;
		}

		@Override
		public boolean containsAll(Collection c) {
			return false;
		}

		@Override
		public boolean addAll(Collection c) {
			
			return false;
		}

		@Override
		public boolean addAll(int index, Collection c) {
			return false;
		}

		@Override
		public boolean removeAll(Collection c) {
			return false;
		}

		@Override
		public boolean retainAll(Collection c) {
			return false;
		}

		@Override
		public void clear() {
		}

		@Override
		public Object get(int index) {
			return null;
		}

		@Override
		public Object set(int index, Object element) {
			return null;
		}

		@Override
		public void add(int index, Object element) {
			
		}

		@Override
		public Object remove(int index) {
			return null;
		}

		@Override
		public int indexOf(Object o) {
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			return 0;
		}

		@Override
		public ListIterator listIterator() {
			return null;
		}

		@Override
		public ListIterator listIterator(int index) {
			return null;
		}

		@Override
		public List subList(int fromIndex, int toIndex) {
			return null;
		}
		
	};
	
	Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	public void m1(int param1) {
		final int varLocal = 50;
		
		// varLocal++;
		// param1++;
		
		class MethodLocalInnerClass {
			// private static int varStatic = 40; // erro
			private final static int varStatic = 40;
			
			public void print() {
				System.out.println(OuterClass.this.field1);
				System.out.println(OuterClass.this.field2);
				System.out.println(varLocal); // variavel local ou parametro do método devem ser final
				System.out.println(param1);
			}
		}
		
		MethodLocalInnerClass localInnerClass = new MethodLocalInnerClass();
		localInnerClass.print();
	}
	
	//private
	//protected
	//public
	static class StaticInnerClass {
		public interface a {
			
		}
		
		private static int varStatic = 50;
		
		private int varNonstatic = OuterClass.vStatic;
		
		// private int f = OuterClass.this.field1; // erro
		private int f = new OuterClass().field1;
	}
	
	//private
	//protected
	//public
	class InnerClass {
		// public interface test { // erro
		//	
		// }
		
		// private static int varStatic = 30; // erro
		private static final int varStatic = 30;
		private int i = 20;
		
		public void m1(int i) {
			OuterClass.this.field1 = 10;
			System.out.println("i = " + i);
			System.out.println("campo i da inner class: " + this.i);
			System.out.println("campo i da classe externa: " + OuterClass.this.i);
		}
	}
	
	public static void main(String[] args) {
		// instânciando uma inner class estática 
		OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
		
		// intânciando uma inner class regular
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.m1(100);
		
		outerClass.m1(300);
		
	}
}
