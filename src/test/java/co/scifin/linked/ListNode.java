package co.scifin.linked;

public class ListNode
{
	int val;
	ListNode next;

	ListNode()
	{
	}

	ListNode(int val)
	{
		this.val = val;
	}

	ListNode(int val, ListNode next)
	{
		this.val = val;
		this.next = next;
	}

    public void append(int i)
    {
        this.next = new ListNode(i);
    }
}
