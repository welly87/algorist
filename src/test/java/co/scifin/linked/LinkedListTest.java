package co.scifin.linked;

import org.junit.Assert;
import org.junit.Test;

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
}
