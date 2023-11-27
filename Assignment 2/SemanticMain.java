import org.apache.commons.lang3.time.StopWatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SemanticMain {
    public List<String> listVocabulary = new ArrayList<>();  //List that contains all the vocabularies loaded from the csv file.
    public List<double[]> listVectors = new ArrayList<>(); //Associated vectors from the csv file.
    public List<Glove> listGlove = new ArrayList<>();
    public final List<String> STOPWORDS;

    public SemanticMain() throws IOException {
        STOPWORDS = Toolkit.loadStopWords();
        Toolkit.loadGLOVE();
    }


    public static void main(String[] args) throws IOException {
        StopWatch mySW = new StopWatch();
        mySW.start();
        SemanticMain mySM = new SemanticMain();
        mySM.listVocabulary = Toolkit.getListVocabulary();
        mySM.listVectors = Toolkit.getlistVectors();
        mySM.listGlove = mySM.CreateGloveList();

        List<CosSimilarityPair> listWN = mySM.WordsNearest("computer");
        Toolkit.PrintSemantic(listWN, 5);

        listWN = mySM.WordsNearest("phd");
        Toolkit.PrintSemantic(listWN, 5);

        List<CosSimilarityPair> listLA = mySM.LogicalAnalogies("china", "uk", "london", 5);
        Toolkit.PrintSemantic("china", "uk", "london", listLA);

        listLA = mySM.LogicalAnalogies("woman", "man", "king", 5);
        Toolkit.PrintSemantic("woman", "man", "king", listLA);

        listLA = mySM.LogicalAnalogies("banana", "apple", "red", 3);
        Toolkit.PrintSemantic("banana", "apple", "red", listLA);
        mySW.stop();

        if (mySW.getTime() > 2000)
            System.out.println("It takes too long to execute your code!\nIt should take less than 2 second to run.");
        else
            System.out.println("Well done!\nElapsed time in milliseconds: " + mySW.getTime());
    }

    public List<Glove> CreateGloveList() {
        List<Glove> listResult = new ArrayList<>();
        //TODO Task 6.1
        for (int j = 0; j < listVocabulary.size(); j++) {
            if (!STOPWORDS.contains(listVocabulary.get(j))) {
                listResult.add(new Glove(listVocabulary.get(j), new Vector(listVectors.get(j))));
            }
        }
        return listResult;
    }

    public List<CosSimilarityPair> WordsNearest(String _word) {
        //TODO Task 6.2
        List<CosSimilarityPair> listCosSimilarity = new ArrayList<>();
        int wordInd = 0;
        int errorIndex = 0;
        for (int k = 0; k<listGlove.size(); k++) {
            if (listGlove.get(k).getVocabulary().equals("error")) {
                errorIndex = k;
            }
        }
        for (int j = 0; j <listGlove.size(); j++) {
            if (listGlove.get(j).getVocabulary().equals(_word)) {
                wordInd = j;
                break;
            }
        }

        for (Glove glove :listGlove) {
            if (wordInd == 0) {
                _word = "error";
                if (!glove.getVocabulary().equals(_word)) {
                    listCosSimilarity.add(new CosSimilarityPair(_word, glove.getVocabulary(),
                            glove.getVector().cosineSimilarity(listGlove.get(errorIndex).getVector())));
            }
        }
            else if (!glove.getVocabulary().equals(_word)) {
                listCosSimilarity.add(new CosSimilarityPair(_word, glove.getVocabulary(),
                        glove.getVector().cosineSimilarity(listGlove.get(wordInd).getVector())));
            }
        }
            return HeapSort.doHeapSort(listCosSimilarity);
    }

    public List<CosSimilarityPair> WordsNearest(Vector _vector) {
        List<CosSimilarityPair> listCosSimilarity = new ArrayList<>();
        //TODO Task 6.3
        for (Glove glove :listGlove) {
            if (!_vector.equals(glove.getVector())) {
                listCosSimilarity.add(new CosSimilarityPair(_vector, glove.getVocabulary(),
                        _vector.cosineSimilarity(glove.getVector())));
            }
        }
        return HeapSort.doHeapSort(listCosSimilarity);
    }

    /**
     * Method to calculate the logical analogies by using references.
     * <p>
     * Example: uk is to london as china is to XXXX.
     *       _firISRef  _firTORef _secISRef
     * In the above example, "uk" is the first IS reference; "london" is the first TO reference
     * and "china" is the second IS reference. Moreover, "XXXX" is the vocabulary(ies) we'd like
     * to get from this method.
     * <p>
     * If _top <= 0, then returns an empty listResult.
     * If the vocabulary list does not include _secISRef or _firISRef or _firTORef, then returns an empty listResult.
     *
     * @param _secISRef The second IS reference
     * @param _firISRef The first IS reference
     * @param _firTORef The first TO reference
     * @param _top      How many vocabularies to include.
     */
    public List<CosSimilarityPair> LogicalAnalogies(String _secISRef, String _firISRef, String _firTORef, int _top) {
        List<CosSimilarityPair> listResult = new ArrayList<>();
        int idxsecisref = 0;
        int idxfirtoref = 0;
        int idxfirisref = 0;
        Vector secisref = null;
        Vector firisref = null;
        Vector firtoref = null;

        try {
            for (int i = 0; i < listGlove.size(); i++) {
                if (listGlove.get(i).getVocabulary().equals(_secISRef)) {
                    idxsecisref = i;
                    secisref = listGlove.get(idxsecisref).getVector();
                }
                if (listGlove.get(i).getVocabulary().equals(_firTORef)) {
                    idxfirtoref = i;
                    firtoref = listGlove.get(idxfirtoref).getVector();

                }
                if (listGlove.get(i).getVocabulary().equals(_firISRef)) {
                    idxfirisref = i;
                    firisref = listGlove.get(idxfirisref).getVector();

                }
            }


            Vector newVector = (secisref.add(firtoref)).subtraction(firisref);

            List<CosSimilarityPair> myList = WordsNearest(newVector);

            for (int j = 0; j < _top; j++) {
                if ((myList.get(j).getWord2().equals(_secISRef)) || (myList.get(j).getWord2().equals(_firISRef)) || (myList.get(j).getWord2().equals(_firTORef))) {
                    myList.remove(j);
                }

            }

            for (int i = 0; i < _top; i++) {
                {

                    listResult.add(myList.get(i));
                }

            }
            return listResult;


        } catch (NullPointerException e) {
            return listResult;
        }
    }
}



