package NodeUtility;

import components.map.Map.Pair;
import components.sequence.Sequence;

public interface NodeKernel {

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
    void addSignalPair(Double s, Double w);

    /**
     * Removes a signal {@code s} with weight {@code w } from {@code this}.
     *
     * @param s
     *            signal to add to {@code this}
     * @updates this.pairs
     * @requires this contains s and this.pairsProcessed = false
     * @ensures this = #this - s - w
     */
    void removeSignalPair(Double s);

    /**
     * Sets the {@code threshold} of {@code this}.
     *
     * @param t
     *            {@code threshold} to set {@code this} to
     * @replaces this.threshold
     * @requires t =< 1.0 and t >= 0.00
     * @ensures this.threshold = t
     */
    void setThreshold(Double t);

    /**
     * Gets the {@code threshold} of {@code this}.
     *
     * @param t
     *            {@code threshold} to set {@code this} to
     * @replaces this.threshold
     * @ensures getThreshold = this.threshold
     */
    public Double getThreshold();

    /**
     * Processes all signal pairs in {@code this}(multiplies every signal by its
     * corresponding weight and stores them in this.signals).
     *
     * @updates this.pairs
     * @requires this.pairs /= <>
     * @ensures this.pairs = <all signals * their weights (s * w), 0.0>
     */
    void processAllSignalPairs();

    /**
     * Gets the pairs from {@code this.pairs}.
     *
     * @return this.pairs
     * @ensures getPairs = this.pairs
     */
    public Sequence<Pair<Double, Double>> getPairs();

    /**
     * Reports whether {@code this} has been processed.
     *
     * @return this.pairsProcessed
     * @ensures pairsProcessed = this.pairsProcessed
     */
    public boolean pairsProcessed();

}
