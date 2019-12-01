package hu.bme.mit.mealeymodel.dhc.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import hu.bme.mit.mealeymodel.dhc.teacher.Teacher;

public abstract class DiscriminationTree<DSCR, I, O, D, N extends DiscriminationTreeNode<DSCR, O, D, N>> {
	protected final N root;
	Teacher<I, O, ?> teacher;

    public DiscriminationTree(N root, Teacher<?, ? extends O, ?> teacher) {
        this.root = root;
    }

    public N sift(List<I> prefix) {
        return sift(root, prefix);
    }

    public N sift(N start, List<I> prefix) {
        return sift(start, prefix, n -> !n.isLeaf());
    }

    protected N sift(N start, List<I> prefix, Predicate<N> continueExploring) {
        N curr = start;

        while (continueExploring.test(curr)) {
            final List<I> query = buildQuery(curr, prefix);
            O result = teacher.membershipQuery(query);
            curr = curr.child(result);
        }

        return curr;
    }

    public List<N> sift(List<N> starts, List<List<I>> prefixes) {
        assert starts.size() == prefixes.size();
        return sift(starts, prefixes, n -> !n.isLeaf());
    }

    protected List<N> sift(List<N> starts, List<List<I>> prefixes, Predicate<N> continueExploring) {
        assert starts.size() == prefixes.size();

        if (starts.isEmpty()) {
            return Collections.emptyList();
        } else if (starts.size() == 1) {
            return Collections.singletonList(sift(starts.get(0), prefixes.get(0), continueExploring));
        }

        final int size = starts.size();
        final List<N> result = new ArrayList<>(starts);
        final BitSet activeVector = new BitSet(size);

        for (int i = 0; i < size; i++) {
            activeVector.set(i, continueExploring.test(result.get(i)));
        }

        final List<List<I>> prefixStorage;
        if (prefixes instanceof RandomAccess) {
            prefixStorage = prefixes;
        } else {
            prefixStorage = new ArrayList<>(prefixes);
        }

        while (!activeVector.isEmpty()) {

            final List<List<I>> queries = new ArrayList<>(activeVector.cardinality());
            final BitSetIterator preIter = new BitSetIterator(activeVector);

            while (preIter.hasNext()) {
                final int idx = preIter.nextInt();
                queries.add(buildQuery(result.get(idx), prefixStorage.get(idx)));
            }
            
            final BitSetIterator postIter = new BitSetIterator(activeVector);
            
            for(List<I> q : queries) {
                final int idx = postIter.nextInt();
                final N current = result.get(idx);
                final O out = teacher.membershipQuery(q);
                final N child = current.child(out);
                result.set(idx, child);

                if (!continueExploring.test(child)) {
                    activeVector.clear(idx);
                }
            }
        }

        return result;
    }

    public N getRoot() {
        return root;
    }

    public N leastCommonAncestor(N a, N b) {
        N lower, higher;

        if (a.getDepth() > b.getDepth()) {
            lower = a;
            higher = b;
        } else {
            lower = b;
            higher = a;
        }

        while (lower.getDepth() > higher.getDepth()) {
            lower = lower.getParent();
        }

        while (lower != higher) {
            lower = lower.getParent();
            higher = higher.getParent();
        }

        return lower;
    }

    /**
     * Fetches for two nodes information about their lowest common ancestor in {@code this} discrimination tree. {@link
     * LCAInfo#subtree1Label} will reference the label of the outgoing child transition for the node closer to the LCA,
     * {@link LCAInfo#subtree2Label} the label of the outgoing child transition for the node farther away from the LCA.
     * If both nodes have equal depth, {@link LCAInfo#subtree1Label} contains {@code node1}'s label and {@link
     * LCAInfo#subtree2Label} {@code node2}'s label.
     * <p>
     * Either {@link LCAInfo#subtree1Label} or {@link LCAInfo#subtree2Label} is {@code null}, if {@code node1} ({@code
     * node2} respectively) already is the LCA.
     *
     * @param node1
     *         first node
     * @param node2
     *         second node
     *
     * @return the corresponding {@link LCAInfo}.
     */
    public LCAInfo<O, N> lcaInfo(N node1, N node2) {
        int d1 = node1.depth;
        int d2 = node2.depth;

        int ddiff = d2 - d1;

        boolean swap = false;

        N curr1, curr2;
        if (ddiff >= 0) {
            curr1 = node1;
            curr2 = node2;
        } else {
            curr1 = node2;
            curr2 = node1;
            ddiff *= -1;
            swap = true;
        }

        O out1 = null, out2 = null;
        while (ddiff > 0) {
            out2 = curr2.parentOutcome;
            curr2 = curr2.parent;
            ddiff--;
        }

        if (curr1 == curr2) {
            return new LCAInfo<>(curr1, out1, out2, swap);
        }

        while (curr1 != curr2) {
            out1 = curr1.parentOutcome;
            curr1 = curr1.parent;
            out2 = curr2.parentOutcome;
            curr2 = curr2.parent;
        }

        return new LCAInfo<>(curr1, out1, out2, swap);
    }

    protected abstract List<I> buildQuery(N node, List<I> prefix);

    public Collection<N> getNodes() {
        List<N> nodes = new ArrayList<>();
        Deque<N> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	N curr = queue.poll();
        	nodes.add(curr);
        	for(Entry<O, N> e : curr.getChildEntries()) {
        		if(!nodes.contains(e.getValue())) {
        			queue.add(e.getValue());
        		}
        	}
        }
        return nodes;
    }

    public Collection<Entry<O, N>> getOutgoingEdges(N node) {
        if (node.isLeaf()) {
            return Collections.emptySet();
        }
        return node.getChildEntries();
    }

    public N getTarget(Entry<O, N> edge) {
        return edge.getValue();
    }
    public class LCAInfo<O, N> {

        public final N leastCommonAncestor;

        public final O subtree1Label;

        public final O subtree2Label;

        public LCAInfo(N leastCommonAncestor, O subtree1Label, O subtree2Label) {
            this(leastCommonAncestor, subtree1Label, subtree2Label, false);
        }

        LCAInfo(N leastCommonAncestor, O subtree1Label, O subtree2Label, boolean swap) {
            this.leastCommonAncestor = leastCommonAncestor;
            if (swap) {
                this.subtree1Label = subtree2Label;
                this.subtree2Label = subtree1Label;
            } else {
                this.subtree1Label = subtree1Label;
                this.subtree2Label = subtree2Label;
            }
        }
    }
    public class BitSetIterator implements Iterator<Integer> {

        private final BitSet bitSet;
        private int currBitIdx;
        private int lastBitIdx;

        /**
         * Constructor.
         *
         * @param bitSet
         *         the bitset over which to iterate.
         */
        public BitSetIterator(BitSet bitSet) {
            this.bitSet = bitSet;
            this.currBitIdx = bitSet.nextSetBit(0);
            this.lastBitIdx = -1;
        }

        @Override
        public boolean hasNext() {
            return (currBitIdx != -1);
        }

        @Override
        public void remove() {
            if (lastBitIdx == -1) {
                throw new NoSuchElementException();
            }
            bitSet.clear(lastBitIdx);
        }

        public int nextInt() {
            if (currBitIdx == -1) {
                throw new NoSuchElementException();
            }
            lastBitIdx = currBitIdx;
            currBitIdx = bitSet.nextSetBit(currBitIdx + 1);

            return lastBitIdx;
        }

		@Override
		public Integer next() {
			throw new IllegalStateException();
		}
    }
}
