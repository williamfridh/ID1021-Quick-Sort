class LinkedList {

	Node head;
	Node tail;



	private class Node {

		Integer item;
		Node	next;

		private Node (Integer i, Node l) {
			item = i;
			next = l;
		}

	}



	LinkedList() {
		head = null;
	}



    /*
     * Quick sort.
     */
	public void quickSort() {
		Node pivot = tail;
		LinkedList smaller = new LinkedList();
		LinkedList larger = new LinkedList();
		
		Node t = head;
		while (t != pivot) {
			if (t.item.compareTo(pivot.item) > 0) { // Larger.
				larger.add(t);
			} else { // Smaller.
				smaller.add(t);
			}
		}

		head = null;

		smaller.sort();
		larger.sort();

		add(smaller.head);
		add(pivot);
		add(larger.head);

		smaller.head = null;
		smaller.tail = null;

		larger.head = null;
		larger.tail = null;
	}



	/**
	 * Sort.
	 */
	public void sort() {

		// Find smallest.
		Node newHead = head;
		Node newTail = tail;

		Node l = head;
		while (l != null) {

			if (newHead.item.compareTo(l.item) > 0)
				newHead = l;
			if (newTail.item.compareTo(l.item) < 0)
				newTail = l;

			l = l.next;
		}

		System.out.println("New head: " + newHead.item);
		System.out.println("New tail: " + newTail.item);

		// Build upon smallest.
		Node workOn = newHead;
		while (true) {
			
			Node itter = head;
			Node n = workOn.next;

			while (itter.next != null) {
				System.out.println(itter.item);
				//System.out.println(itter.item);
				if (n.item.compareTo(itter.item) > 0 && itter != workOn) {
					//System.out.println("TRIGGER");
					n = itter;
				}
				itter = itter.next;
			}

			workOn.next = n;

			System.out.println("New tail: " + n.item);

			if (workOn.next == newTail)
				break;

		}

	}



	/**
	 * Print the queue for debugging.
	 * 
	 * @return string displaying queue.
	 */
	public String toString() {
		String s = "";
		Node n = head;
		while (n != null) {
			s += n.item + " --> ";
			n = n.next;
		}
		return s;
	}



	/**
	 * Add Node to the queue.
	 * 
	 * Big-O complecity is O(n) since we need to iterate torught the whole queue.
	 * 
	 * @param item for the node to hold.
	 */
	public void add(Node n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	public void add(Integer item) {
		Node n = new Node(item, null);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}



	/**
	 * Remove the first element of the list and return its value.
	 * 
	 * Big-O complexity is O(1) since we don't perform any loops.
	 * 
	 * @return value of removed element.
	 */
	public Integer remove() {
		if (head == null)
			return null;
		Integer t = head.item;
		head = head.next;
		return t;
	}

}