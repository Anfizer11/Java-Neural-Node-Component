package NodeUtility;

import components.map.Map.Pair;

public abstract class NodeSecondary extends Object implements Node {

    /*
     * Object methods ---------------------------------------------------------
     */

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("( [");
        int index = 0;

        for (Pair<Double, Double> x : this.getPairs()) {
            index++;

            result.append(this.getPairs().entry(index).key() + ", "
                    + this.getPairs().entry(index).key() + ", ");

        }
        result.deleteCharAt(result.length());
        result.deleteCharAt(result.length());

        result.append("], Threshold: ");
        result.append(this.getThreshold());
        result.append(",[contents])");
        return result.toString();

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node n = (Node) obj;
        if (this.getThreshold() != n.getThreshold()) {
            return false;
        }
        if (this.getPairs() != n.getPairs()) {
            return false;
        }

        return true;

    }

    /*
     * Secondary methods -----------------------------------------------------
     */

    /**
     * Determines if the Neuron ({@code n}) activates based on an input (if it
     * reaches the threshold otherwise known as the transfer function).
     *
     * @param n
     *            node to be compared with to the threshold of {@code this}
     * @return whether the node activates
     * @requires Node /= <> and this.pairsProcessed = true
     * @ensures activates = n.getAxion > this.threshold
     */
    @Override
    public boolean activates(Node n) {
        assert n != null : "Violation of: Node must not be null";
        assert this
                .pairsProcessed() == true : "Violation of: this must be processed";

        boolean value = false;

        if (n.getAxon() > this.getThreshold()) {
            value = true;
        }

        return value;
    }

    /**
     * Takes all signal pairs in {@code this} that are processed and adds them
     * together (sum of all the signals multiplied by their corresponding
     * weights that are in this.pairs).
     *
     * @return the sum of all processed signals
     * @requires |this.pairs| >= 1 and this.pairsProcessed = true
     * @ensures sumSignals = the sum of all signals
     */
    @Override
    public double sumSignals() {
        assert this.getPairs()
                .length() >= 1 : "Violation of: node must have length >= 1";
        assert this
                .pairsProcessed() == true : "Violation of: this must be processed";

        Double val = 0.0;

        for (Pair<Double, Double> x : this.getPairs()) {

            val += x.key();

        }

        return val;
    }

    /**
     * Ensures all pairs of {@code this} have been processed then passes the sum
     * to the threshold function and returns the value returned to find the
     * axon.
     *
     * @return the axon of the signals stored in {@code this}
     * @requires this.signalPairs /= <> and this.pairsProcessed = true
     * @ensures this.pairs = #this.pairs and this.getAxion = the standardization
     *          of the sum of all pairs
     */
    @Override
    public double getAxon() {
        assert this.getPairs() != null : "Violation of: Node must not be null";
        assert this
                .pairsProcessed() == true : "Violation of: this must be processed";

        double sum = this.sumSignals();
        double min = this.getPairs().entry(0).key();
        double max = this.getPairs().entry(0).key();
        double val = 0.0;

        //finds the minimum and maximum of the different inputs
        for (Pair<Double, Double> x : this.getPairs()) {

            if (x.key() > max) {
                max = x.key();
            }
            if (x.key() < min) {
                min = x.key();
            }

        }

        val = (sum - min) / (max - min); // standardizes the axion(returns a value between 0 and 1)

        return val;
    }

}
