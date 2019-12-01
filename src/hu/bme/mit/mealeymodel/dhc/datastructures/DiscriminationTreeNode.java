package hu.bme.mit.mealeymodel.dhc.datastructures;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;


abstract class DiscriminationTreeNode<DSCR, O, D, T extends DiscriminationTreeNode<DSCR, O, D, T>>{
	protected final T parent;
    protected final O parentOutcome;
    protected final int depth;
    protected Map<O, T> children;
    protected DSCR discriminator;
    protected D data;
    
    public DiscriminationTreeNode(D data) {
        this(null, null, data);
    }

    public DiscriminationTreeNode(T parent, O parentOutcome, D data) {
        this.parent = parent;
        this.parentOutcome = parentOutcome;
        this.depth = (parent != null) ? parent.depth + 1 : 0;
        this.data = data;
    }
    public boolean isRoot() {
        return parent == null;
    }

    public T getParent() {
        return parent;
    }

    public DSCR getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(DSCR discriminator) {
        this.discriminator = discriminator;
    }

    public SplitResult split(DSCR discriminator, O oldOut, O newOut) {
        return this.split(discriminator, oldOut, newOut, null);
    }

    public SplitResult split(DSCR discriminator, O oldOut, O newOut, D newData) {
        assert this.isLeaf();
        assert !Objects.equals(oldOut, newOut);

        this.children = createChildMap();

        final T nodeOld = addChild(oldOut, this.data);
        final T nodeNew = addChild(newOut, newData);

        this.data = null;
        this.discriminator = discriminator;

        return new SplitResult(nodeOld, nodeNew);
    }

    public boolean isLeaf() {
        return (children == null);
    }

    protected abstract Map<O, T> createChildMap();

    protected T addChild(O outcome, D data) {
        final T child = createChild(outcome, data);
        children.put(outcome, child);
        return child;
    }

    protected abstract T createChild(O outcome, D data);

    public T child(O out) {
        return child(out, null);
    }

    public T child(O out, D defaultData) {
        assert !isLeaf();

        T result = getChild(out);
        if (result == null) {
            result = addChild(out, defaultData);
        }
        return result;
    }

    public T getChild(O out) {
        return children.get(out);
    }

    public Collection<T> getChildren() {
        return children.values();
    }

    public Collection<Map.Entry<O, T>> getChildEntries() {
        return children.entrySet();
    }

    public void replaceChildren(Map<O, T> repChildren) {
        this.children = repChildren;
    }

    public int getDepth() {
        return depth;
    }

    public D getData() {
        assert isLeaf();
        return data;
    }

    public void setData(D data) {
        assert isLeaf();
        this.data = data;
    }

    public O subtreeLabel(T descendant) {
        T curr = descendant;

        while (curr.depth > this.depth + 1) {
            curr = curr.parent;
        }

        if (curr.parent != this) {
            return null;
        }

        return curr.getParentOutcome();
    }

    public O getParentOutcome() {
        return parentOutcome;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + depth;
		result = prime * result + ((discriminator == null) ? 0 : discriminator.hashCode());
		result = prime * result + ((parentOutcome == null) ? 0 : parentOutcome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscriminationTreeNode other = (DiscriminationTreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (depth != other.depth)
			return false;
		if (discriminator == null) {
			if (other.discriminator != null)
				return false;
		} else if (!discriminator.equals(other.discriminator))
			return false;
		if (parentOutcome == null) {
			if (other.parentOutcome != null)
				return false;
		} else if (!parentOutcome.equals(other.parentOutcome))
			return false;
		return true;
	}

	public class SplitResult {

        public final T nodeOld;
        public final T nodeNew;

        public SplitResult(T nodeOld, T nodeNew) {
            this.nodeOld = nodeOld;
            this.nodeNew = nodeNew;
        }
    }
}
