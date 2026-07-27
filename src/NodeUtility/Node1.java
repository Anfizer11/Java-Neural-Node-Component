package NodeUtility;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class Node1 extends NodeSecondary {

    /*
     * Private members -------------------------------------------------------
     */

    private Sequence<Pair<Double, Double>> pairs;
    private double threshold;
    private boolean pairsProcessed;

    /**
     * Checks that {@Code this} hasKey s.
     *
     * @param s
     *            signal to check that this.pairs has
     * @return true iff there is a pair in this whose first component is s
     * @ensures hasKey = (key is in DOMAIN(this))
     */
    private boolean hasKey(Double s) {

        int index = 0;
        boolean val = false;

        for (Pair<Double, Double> x : this.pairs) {

            index++;

            if (this.pairs.entry(index).key() == s) {
                val = true;
                break;
            }

        }

        return val;

    }

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.pairs = new Sequence1L<Pair<Double, Double>>();
        this.threshold = 0.5;
        this.pairsProcessed = false;

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Node1() {

        this.createNewRep();

    }

    /*
     * Kernel methods --------------------------------------------------------
     */

    /**
     * Adds a signal {@code s} with weight {@code w} to {@code this}.
     *
     * @param s
     *            signal to add to {@code this}
     * @param w
     *            weight to add to {@code this}
     * @updates this.pairs
     * @requires this.pairsProcessed = false
     * @ensures this.pairs = #this.pair + <s, w>
     */
    @Override
    public void addSignalPair(Double s, Double w) {
        assert this.pairsProcessed == false : "Violation of: this must not be processed yet";

        Map<Double, Double> temp = new Map1L<Double, Double>();
        temp.add(s, w);

        this.pairs.add(this.pairs.length(), temp.removeAny());
    }

    /**
     * Removes a signal {@code s} with weight {@code w } from {@code this}.
     *
     * @param s
     *            signal to add to {@code this}
     * @updates this.pairs
     * @requires this contains s and this.pairsProcessed = false
     * @ensures this = #this - s - w
     */
    @Override
    public void removeSignalPair(Double s) {
        assert this.hasKey(s) == true : "Violation of: signals mut contain s";
        assert this.pairsProcessed == false : "Violation of: this must not be processed yet";

        int index = 0;

        for (Pair<Double, Double> x : this.pairs) {
            index++;

            if (this.pairs.entry(index).key() == s) {
                this.pairs.remove(index);
                break;
            }

        }
    }

    /**
     * Sets the {@code threshold} of {@code this}.
     *
     * @param t
     *            {@code threshold} to set {@code this} to
     * @replaces this.threshold
     * @requires t =< 1.0 and t >= 0.00
     * @ensures this.threshold = t
     */
    @Override
    public void setThreshold(Double t) {
        assert t <= 1
                && t >= 0.0 : "Violation of: threshold must be under 1 and above 0";
        this.threshold = t;
    }

    /**
     * Gets the {@code threshold} of {@code this}.
     *
     * @param t
     *            {@code threshold} to set {@code this} to
     * @replaces this.threshold
     * @ensures getThreshold = this.threshold
     */
    @Override
    public Double getThreshold() {
        return this.threshold;
    }

    /**
     * Processes all signal pairs in {@code this}(multiplies every signal by its
     * corresponding weight and stores them in this.signals).
     *
     * @updates this.pairs
     * @requires this.pairs /= <>
     * @ensures this.pairs = <all signals * their weights (s * w), 0.0>
     */
    @Override
    public void processAllSignalPairs() {
        assert this.pairs != null : "Violation of: this cannot be null";

        boolean pairsProcessed = true;
        int index = 0;

        Map<Double, Double> temp = new Map1L<Double, Double>();

        for (Pair<Double, Double> x : this.pairs) {
            index++;

            temp.add(this.pairs.entry(index).key()
                    * this.pairs.entry(index).value(), 0.0);

            this.pairs.replaceEntry(index, temp.removeAny());

        }
    }

    /**
     * Gets the pairs from {@code this.pairs}.
     *
     * @return this.pairs
     * @ensures getPairs = this.pairs
     */
    @Override
    public Sequence<Pair<Double, Double>> getPairs() {

        return this.pairs;
    }

    /**
     * Reports whether this has been processed.
     *
     * @return this.pairsProcessed
     * @ensures pairsProcessed = this.pairsProcessed
     */
    @Override
    public boolean pairsProcessed() {
        return this.pairsProcessed;
    }

}
