package suffix_tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SuffixTree suffixTree = new SuffixTree("kdslgjsggcfrhnnslgnhgddsslgvfnghcslgvf");
        List<Integer> list = suffixTree.search("slg");
        System.out.println("Find " + list.size() + " match");
        System.out.println(SuffixTree.z);
        list.forEach(System.out::println);
    }
}
