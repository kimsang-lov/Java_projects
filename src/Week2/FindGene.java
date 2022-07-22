package Week2;

public class FindGene {
    public String findGeneSimple(String dna) {
        // Start codon is "ATG"
        // Stop codon is "TAA"
        String result = "";
        int start_codon = dna.indexOf("ATG");
        if (start_codon == -1) { // when there is no ATG
            return "not found";
        }
        int stop_codon = dna.indexOf("TAA", start_codon+3);
        if (stop_codon == -1) { // when there is no TAA
            return "not found";
        }
        result = dna.substring(start_codon, stop_codon+3);

        if (result.length() % 3 != 0) {
            return "not found";
        }

        return result;
    }
    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        String dna2 = "AATGCTAGGGTAATATGGT";
        System.out.println("Second DNA strand is " + dna2);
        String gene2 = findGeneSimple(dna2);
        System.out.println("Second gene is " + gene2);

        String dna3 = "ATCCTATGCTTCGGTTCGGCTGCTCTAATATGGT";
        System.out.println("Third DNA strand is " + dna3);
        String gene3 = findGeneSimple(dna3);
        System.out.println("Third gene is " + gene3);

        String dna4 = "TACTAATTG";
        System.out.println("Fourth DNA strand is " + dna4);
        String gene4 = findGeneSimple(dna4);
        System.out.println("Fourth gene is " + gene4);

        String dna5 = "CGATGGGTTTG";
        System.out.println("Fifth DNA strand is " + dna5);
        String gene5 = findGeneSimple(dna5);
        System.out.println("Fifth gene is " + gene5);

        String dna6 = "ATGACCTATAA";
        System.out.println("Sixth DNA strand is " + dna6);
        String gene6 = findGeneSimple(dna6);
        System.out.println("Sixth gene is " + gene6);
    }
    public static void main(String[] args) {
        FindGene g = new FindGene();
        g.testFindGeneSimple();
        FindGene2 g2 = new FindGene2();
        g2.testFindGene2();
    }

}
class FindGene2 { // Part 2
    public String findGeneSimple2(String dna, String startCodon, String stopCodon) {
        // Start codon is "ATG"
        // Stop codon is "TAA"
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        String result2 = "";

        int start_codon = dna.indexOf(startCodon);
        if (start_codon == -1) { // when there is no ATG
            return "not found";
        }
        int stop_codon = dna.indexOf(stopCodon, start_codon+3);
        if (stop_codon == -1) { // when there is no TAA
            return "not found";
        }
        result2 = dna.substring(start_codon, stop_codon+3);

        if (result2.length() % 3 != 0) {
            return "not found";
        }

        return result2;
    }
    public void testFindGene2() {
        String dna7 = "ATGGGTTAAGTC";
        System.out.println("Seventh DNA strand is " + dna7);
        String gene7 = findGeneSimple2(dna7, "ATG", "TAA");
        System.out.println("Seventh gene is " + gene7);

        String dna8 = "gatgctataat";
        System.out.println("Eighth DNA strand is " + dna8);
        String gene8 = findGeneSimple2(dna8, "atg", "taa");
        System.out.println("Eighth gene is " + gene8);
    }
}