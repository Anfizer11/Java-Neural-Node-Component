package NodeUtility;

public interface Node extends NodeKernel {

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
    boolean activates(Node n);

    /**
     * Takes all signal pairs in {@code this} that are processed and adds them
     * together (sum of all the signals multiplied by their corresponding
     * weights that are in this.pairs).
     *
     * @return the sum of all processed signals
     * @requires |this.pairs| >= 1 and this.pairsProcessed = true
     * @ensures sumSignals = the sum of all signals
     */
    double sumSignals();

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
    double getAxon();
}
