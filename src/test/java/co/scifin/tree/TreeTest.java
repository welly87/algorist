package co.scifin.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class TreeTest
{
	public int rangeSumBST(TreeNode root, int low, int high)
	{
		if (root == null) return 0;

		var sum = rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

		if (root.val <= high && root.val >= low)
		{
			return root.val + sum;
		}

		return sum;
	}

	@Test
	public void testRangeSum()
	{
		var nodes = new int[]{10, 5, 15, 3, 7, -1, 18};
		var root = createTree(nodes);

		Assert.assertEquals(32, rangeSumBST(root, 7, 15));
	}

	private TreeNode createTree(int[] nodes)
	{
		var queue = new LinkedList<TreeNode>();

		var idx = 0;
		var root = new TreeNode(nodes[idx++]);
		queue.add(root);

		while (!queue.isEmpty())
		{
			var first = queue.removeFirst();

			var left = nodes[idx++];

			if (left == -1) continue;

			first.addLeft(left);
			queue.add(first.left);

			if (idx >= nodes.length) break;

			var right = nodes[idx++];

			if (right == -1) continue;

			first.addRight(right);
			queue.add(first.right);

			if (idx >= nodes.length) break;
		}

		queue.clear();

		return root;
	}
}
