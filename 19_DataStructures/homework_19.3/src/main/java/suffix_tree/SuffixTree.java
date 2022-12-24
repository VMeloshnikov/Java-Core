package suffix_tree;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuffixTree {
    private Node root;
    public static int z =0;

    public SuffixTree(String text) {
        root = new Node("", -1);

        for (int i = 0; i < text.length(); i++) {
            build(text.substring(i) + "$", i);
        }
    }


    private void build(String suffix, int position) {
        List<Node> nodes = getAllNodesInTraversePath(suffix, root, true);

        if (nodes.size() == 0) {
            root.getNextNodes().add(new Node(suffix, position));
        } else {

            Node lastNode = nodes.remove(nodes.size() - 1);
            String newText = suffix;

            if (nodes.size() > 0) {
                String existingSuffixUpToLastNode = "";
                for (Node node : nodes) {
                    String fragment = node.getFragment();
                    existingSuffixUpToLastNode = existingSuffixUpToLastNode.concat(fragment);
                }
                newText = newText.substring(existingSuffixUpToLastNode.length());
            }
            String currentText = lastNode.getFragment();
            String commonPrefix = getLongestCommonPrefix(currentText, newText);

            if (!commonPrefix.equals(currentText)) {
                String parentText = currentText.substring(0, commonPrefix.length());
                String childText = currentText.substring(commonPrefix.length());

                Node childNode = new Node(childText, lastNode.getPosition());

                if (lastNode.getNextNodes().size() > 0) {
                    while (lastNode.getNextNodes().size() > 0) {
                        childNode.getNextNodes().add(lastNode.getNextNodes().remove(0));
                    }
                }
                lastNode.getNextNodes().add(childNode);
                lastNode.setFragment(parentText);
                lastNode.setPosition(-1);

            }
            String remainingText = newText.substring(commonPrefix.length());
            lastNode.getNextNodes().add(new Node(remainingText, position));

        }


    }

    public List<Integer> search(String query) {
        List<Node> nodes = getAllNodesInTraversePath(query, root, false);
        List<Integer> positions = null;
        List<Integer> result = new ArrayList<>();

        if (nodes.size() > 0) {
            Node lastNode = nodes.get(nodes.size() - 1);
            if (lastNode != null) {
                positions = getPositions(lastNode);
            }
            if (positions != null) {
                result = new ArrayList<>(positions);
                result.sort(Comparator.naturalOrder());
            }
        }
        return result;
    }

    private List<Node> getAllNodesInTraversePath(String pattern, Node startNode, boolean isAllowPartialMatch) {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < startNode.getNextNodes().size(); i++) {

            Node currentNode = startNode.getNextNodes().get(i);
            String nodeText = currentNode.getFragment();

            if (pattern.charAt(0) == nodeText.charAt(0)) {
                if (isAllowPartialMatch && pattern.length() <= nodeText.length()) {
                    nodes.add(currentNode);

                    return nodes;
                }

                int compareLength = Math.min(nodeText.length(), pattern.length());
                for (int j = 1; j < compareLength; j++) {
                    if (pattern.charAt(j) != nodeText.charAt(j)) {
                        if (isAllowPartialMatch) {

                            nodes.add(currentNode);
                        }
                        return nodes;
                    }
                }
                nodes.add(currentNode);

                if (pattern.length() > compareLength) {
                    List<Node> nodes2 = getAllNodesInTraversePath(pattern.substring(compareLength), currentNode, isAllowPartialMatch);
                    if (nodes2.size() > 0) {
                        nodes.addAll(nodes2);
                    } else if (!isAllowPartialMatch) {

                        nodes.add(null);
                    }
                }
                return nodes;
            }
        }
        return nodes;
    }


    private String getLongestCommonPrefix(String str1, String str2) {
        int compareLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < compareLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, compareLength);
    }


    private List<Integer> getPositions(Node node) {
        List<Integer> positions = new ArrayList<>();
        if (node.getFragment().endsWith("$")) {
            positions.add(node.getPosition());
        }
        for (int i = 0; i < node.getNextNodes().size(); i++) {
            positions.addAll(getPositions(node.getNextNodes().get(i)));
        }
        return positions;
    }
}