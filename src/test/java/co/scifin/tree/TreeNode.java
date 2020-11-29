package co.scifin.tree;

public class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode()
	{
	}

	TreeNode(int val)
	{
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public void addLeft(int anInt)
	{
		this.left = new TreeNode(anInt);
	}

	public void addRight(int anInt)
	{
		this.right = new TreeNode(anInt);
	}
}
