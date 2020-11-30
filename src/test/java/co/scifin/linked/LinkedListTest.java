package co.scifin.linked;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LinkedListTest
{
	private ListNode createList(int[] ints)
	{
		var head = new ListNode(ints[0]);
		var tail = head;

		for (int i = 1; i < ints.length; i++)
		{
			tail.append(ints[i]);
			tail = tail.next;
		}

		return head;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode head = null;
		ListNode tail = null;
		var carry = 0;

		while (l1 != null || l2 != null || carry != 0)
		{
			var sum = carry;

			if (l1 != null)
			{
				sum += l1.val;
			}

			if (l2 != null)
			{
				sum += l2.val;
			}

			if (sum >= 10)
			{
				sum = sum % 10;
				carry = 1;
			}
			else
			{
				carry = 0;
			}

			if (head == null)
			{
				head = new ListNode(sum);
				tail = head;
			}
			else
			{
				tail.next = new ListNode(sum);
				tail = tail.next;
			}

			if (l1 != null)
			{
				l1 = l1.next;
			}

			if (l2 != null)
			{
				l2 = l2.next;
			}
		}

		return head;
	}

	@Test
	public void testAddNumbers()
	{
		var l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
		var l2 = createList(new int[]{9, 9, 9, 9});

		var result = addTwoNumbers(l1, l2);

		Assert.assertEquals(8, result.val);
		Assert.assertEquals(9, result.next.val);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode head = null;
		ListNode current = null;

		while (l1 != null && l2 != null)
		{
			var small = -1;

			if (l1.val > l2.val)
			{
				small = l2.val;
				l2 = l2.next;
			}
			else
			{
				small = l1.val;
				l1 = l1.next;
			}

			if (head == null)
			{
				head = new ListNode(small);
				current = head;
			}
			else
			{
				current.next = new ListNode(small);
				current = current.next;
			}
		}

		while (l1 != null)
		{
			if (head == null)
			{
				head = new ListNode(l1.val);
				current = head;
			}
			else
			{
				current.next = new ListNode(l1.val);
				current = current.next;
			}

			l1 = l1.next;
		}

		while (l2 != null)
		{
			if (head == null)
			{
				head = new ListNode(l2.val);
				current = head;
			}
			else
			{
				current.next = new ListNode(l2.val);
				current = current.next;
			}

			l2 = l2.next;
		}

		return head;
	}

	@Test
	public void testMergeList()
	{
		var l1 = createList(new int[]{1, 2, 4});
		var l2 = createList(new int[]{1, 3, 4});

		var result = mergeTwoLists(l1, l2);
		System.out.println(result);
	}

	@Test
	public void testMergeList2()
	{
		var l2 = createList(new int[]{-10, -6, -6, -6, -3, 5});

		var result = mergeTwoLists(l2, null);
		System.out.println(result);
	}

	public int getDecimalValue(ListNode head)
	{
		var length = 0;
		ListNode ptr = head;

		while (ptr != null)
		{
			length++;
			ptr = ptr.next;
		}

		int num = 0;

		ptr = head;
		while (ptr != null)
		{
			length--;

			num += ptr.val * (1 << length);
			ptr = ptr.next;
		}

		return num;
	}

	@Test
	public void testDecimal()
	{
		var l2 = createList(new int[]{1, 0, 1});
		Assert.assertEquals(5, getDecimalValue(l2));
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		ListNode result = null;

		for (var x : lists)
		{
			if (result == null)
			{
				result = x;
			}
			else
			{
				result = mergeTwoLists(result, x);
			}
		}

		return result;
	}

	@Test
	public void testMergingKList()
	{
		var l = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};
		var lst = createLists(l);

		var result = mergeKLists(lst);

		System.out.println(result);
	}

	private ListNode[] createLists(int[][] l)
	{
		var lsts = new ListNode[l.length];

		for (int i = 0; i < lsts.length; i++)
		{
			lsts[i] = createList(l[i]);
		}

		return lsts;
	}

	public ListNode reverseList(ListNode head)
	{
		var ptr = head;

		head = null;

		while (ptr != null)
		{
			var n = new ListNode(ptr.val);
			n.next = head;
			head = n;
			ptr = ptr.next;
		}

		return head;
	}

	@Test
	public void testReverseList()
	{
		var l2 = createList(new int[]{1, 2, 3, 4, 5});
		Assert.assertEquals(5, reverseList(l2).val);
	}

	class Node
	{
		int val;
		Node next;
		Node random;

		public Node(int val)
		{
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head)
	{
		var caches = new Node[1001];

		var ptr = head;
		Node newHead = null;
		Node curr = null;

		while (ptr != null)
		{
			var newNode = new Node(ptr.val);
			caches[ptr.val] = newNode;

			if (newHead == null)
			{
				curr = newNode;
				newHead = curr;
			}
			else
			{
				curr.next = newNode;
				curr = curr.next;
			}

			ptr = ptr.next;
		}

		curr = newHead;
		ptr = head;

		while (ptr != null)
		{
			if (ptr.random != null)
			{
				curr.random = caches[ptr.random.val];
			}

			curr = curr.next;
			ptr = ptr.next;
		}

		return newHead;
	}

	@Test
	public void testDeepCopyList()
	{
		var nums = new int[]{7, 13, 11, 10, 1};
		var nodes = new Node[nums.length];

		Node head = null;
		Node curr = null;

		for (int i = 0; i < nums.length; i++)
		{
			var newNode = new Node(nums[i]);
			nodes[i] = newNode;

			if (head == null)
			{
				head = newNode;
				curr = head;
			}
			else
			{
				curr.next = newNode;
				curr = curr.next;
			}
		}

		var random = new int[]{-1, 0, 4, 2, 0};

		curr = head;

		for (int i = 0; i < nums.length; i++)
		{

			curr.random = random[i] == -1 ? null : nodes[random[i]];
			curr = curr.next;
		}

		System.out.println(head);

		var result = copyRandomList(head);

		System.out.println(result);
	}

	public boolean isPalindrome(ListNode head)
	{
		if (head == null) return true;

		var curr = head;
		var list = new ArrayList<Integer>();

		while (curr != null)
		{
			list.add(curr.val);
			curr = curr.next;
		}

		var memo = list.toArray(new Integer[0]);

		for (int i = 0; i < memo.length / 2; i++)
		{
			if (memo[i].equals(memo[memo.length - i - 1])) return false;
		}

		return true;
	}

	@Test
	public void testPalindrom()
	{

	}
}
