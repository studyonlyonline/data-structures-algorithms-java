package binary_tree_algos;

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class InorderSuccessor
{
    public Node findMin(Node temp){
        while(temp.left !=null){
            // System.out.println("y "+temp.data);
            temp = temp.left;
        }
        return temp;
    }

    public Node findNode(Node root, int data){
        while(root != null && root.data != data){
            if(root.data ==data){
                return root;
            }
            else if(data < root.data){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return root;
    }


    public Node inorderSuccessor(Node root,Node k)
    {
        Node k1=findNode(root, k.data);
        if(k1==null){
            return null;
        }
        //check for right subtree
        if(k1.right!=null){
            Node temp = findMin(k1.right);
            return findMin(k1.right);
        }

        //iif right subtree is empty
        else {
            Node succ=null, ance=root;
            while(ance != k1){
                if(k1.data < ance.data){
                    succ = ance;
                    ance = ance.left;
                }
                else if ( k1.data > ance.data){
                    ance = ance.right;
                }
                else{
                    break;
                }
            }
            return succ;
        }

    }
}