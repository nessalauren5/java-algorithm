import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseTester {
    Parser p = new Parser("shakes.txt");

    @Test
    void testCreate(){
        int result = p.getWordCount("you");
        int result2 = p.getBigramCount("unto", "thine");
        assertEquals(2, result2);
       // assertEquals(result,2258);

    }

    @Test
    void testTop(){
        for(int i=10;i>0;i--){
            String word = p.getNTopWord(i);
            int count = p.getWordCount(word);
            System.out.printf("Top %d: %s %d\n", i, word,count);
        }
    }
    @Test
    void testTopBigram(){
        for(int i=10;i>0;i--){
            String word = p.getNTopBigram(i);
            String[] bigram = word.split(" ");
            int count = p.getBigramCount(bigram[0],bigram[1]);
            System.out.printf("Top %d: %s %s %d\n", i, bigram[0], bigram[1],count);
        }
    }

    @Test
    void testTotalWordCount(){
        System.out.println(p.totalWordCount);
    }
}
