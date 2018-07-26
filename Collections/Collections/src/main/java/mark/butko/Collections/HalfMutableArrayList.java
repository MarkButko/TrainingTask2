package mark.butko.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class HalfMutableArrayList<E> extends ArrayList<E> {

	@Override
	public E set(int index, E element) {
		throw new OperationNotSupportedException();
	}

	@Override
	public void clear() {
		throw new OperationNotSupportedException();
	}

	@Override
	public E remove(int index) {
		throw new OperationNotSupportedException();
	}

	@Override
	public boolean remove(Object o) {
		throw new OperationNotSupportedException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new OperationNotSupportedException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new OperationNotSupportedException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new OperationNotSupportedException();
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		throw new OperationNotSupportedException();
	}

	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		throw new OperationNotSupportedException();
	}
}
