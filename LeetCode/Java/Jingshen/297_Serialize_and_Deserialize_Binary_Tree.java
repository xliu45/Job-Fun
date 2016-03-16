/**Serialize and Deserialize Binary Tree
 * @author liujingshen
 */
 
public class Codec {
   public String serialize(TreeNode root) {
	   StringBuilder s = new StringBuilder();
       serial(root,s);
       return s.toString();
    }
   private void serial(TreeNode t, StringBuilder s)
   {
	   if(t==null)
		   s.append("-,");
	   else
	   {
		   s.append(Integer.toString(t.val)+",");
		   serial(t.left,s);
		   serial(t.right,s);
	   }
   }
    public TreeNode deserialize(String data) {
    	if(data==null)
    		return null;
    	List<String> e=new LinkedList<String>(Arrays.asList(data.split(",")));
    	return deserial(e);
    }
    private TreeNode deserial(List<String> e)
    {
    	if(e.size()==0)
    		return null;
    	String s=e.get(0);
    	e.remove(0);
    	if(s.equals("-"))
    		return null;
    	TreeNode root = new TreeNode(Integer.valueOf(s));
    	root.left=deserial(e);
    	root.right=deserial(e);
    	return root;
    }
    
    public static void main(String[] args) {
  		TreeNode root=new TreeNode(1);
  		root=null;
  		TreeNode l=new TreeNode(2);
  		TreeNode r=new TreeNode(3);
  		//root.left=l;
  		//l.right=r;
  		Codec test=new Codec();
  		//String ss=  "1,2,3";
  		//String ss=null;
  		//TreeNode aa=test.deserialize(ss);
  		String bb=test.serialize(root);
  		TreeNode aa=test.deserialize(bb);
  		System.out.println(bb);
	   }
}
