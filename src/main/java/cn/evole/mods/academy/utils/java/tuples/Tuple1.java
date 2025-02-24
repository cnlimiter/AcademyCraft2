package cn.evole.mods.academy.utils.java.tuples;

import org.zeith.hammerlib.util.java.consumers.Consumer1;
import org.zeith.hammerlib.util.java.functions.Function1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tuple1<A>
		implements ITuple
{
	protected A a;
	
	public Tuple1(A a)
	{
		this.a = a;
	}
	
	public A a()
	{
		return a;
	}
	
	
	public <B> Tuple2<A, B> add(B b)
	{
		return Tuples.immutable(a, b);
	}
	
	public <B, C> Tuple3<A, B, C> add(B b, C c)
	{
		return Tuples.immutable(a, b, c);
	}
	
	public <B, C, D> Tuple4<A, B, C, D> add(B b, C c, D d)
	{
		return Tuples.immutable(a, b, c, d);
	}
	
	public <B, C, D, E> Tuple5<A, B, C, D, E> add(B b, C c, D d, E e)
	{
		return Tuples.immutable(a, b, c, d, e);
	}
	
	public <B, C, D, E, F> Tuple6<A, B, C, D, E, F> add(B b, C c, D d, E e, F f)
	{
		return Tuples.immutable(a, b, c, d, e, f);
	}
	
	public <B, C, D, E, F, G> Tuple7<A, B, C, D, E, F, G> add(B b, C c, D d, E e, F f, G g)
	{
		return Tuples.immutable(a, b, c, d, e, f, g);
	}
	
	public <B, C, D, E, F, G, H> Tuple8<A, B, C, D, E, F, G, H> add(B b, C c, D d, E e, F f, G g, H h)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h);
	}
	
	public <B, C, D, E, F, G, H, I> Tuple9<A, B, C, D, E, F, G, H, I> add(B b, C c, D d, E e, F f, G g, H h, I i)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i);
	}
	
	public <B, C, D, E, F, G, H, I, J> Tuple10<A, B, C, D, E, F, G, H, I, J> add(B b, C c, D d, E e, F f, G g, H h, I i, J j)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j);
	}
	
	public <B, C, D, E, F, G, H, I, J, K> Tuple11<A, B, C, D, E, F, G, H, I, J, K> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L> Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M> Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
	}
	
	public <B> Tuple2<B, A> insert(B b)
	{
		return Tuples.immutable(b, a);
	}
	
	public <B, C> Tuple3<B, C, A> insert(B b, C c)
	{
		return Tuples.immutable(b, c, a);
	}
	
	public <B, C, D> Tuple4<B, C, D, A> insert(B b, C c, D d)
	{
		return Tuples.immutable(b, c, d, a);
	}
	
	public <B, C, D, E> Tuple5<B, C, D, E, A> insert(B b, C c, D d, E e)
	{
		return Tuples.immutable(b, c, d, e, a);
	}
	
	public <B, C, D, E, F> Tuple6<B, C, D, E, F, A> insert(B b, C c, D d, E e, F f)
	{
		return Tuples.immutable(b, c, d, e, f, a);
	}
	
	public <B, C, D, E, F, G> Tuple7<B, C, D, E, F, G, A> insert(B b, C c, D d, E e, F f, G g)
	{
		return Tuples.immutable(b, c, d, e, f, g, a);
	}
	
	public <B, C, D, E, F, G, H> Tuple8<B, C, D, E, F, G, H, A> insert(B b, C c, D d, E e, F f, G g, H h)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, a);
	}
	
	public <B, C, D, E, F, G, H, I> Tuple9<B, C, D, E, F, G, H, I, A> insert(B b, C c, D d, E e, F f, G g, H h, I i)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, a);
	}
	
	public <B, C, D, E, F, G, H, I, J> Tuple10<B, C, D, E, F, G, H, I, J, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K> Tuple11<B, C, D, E, F, G, H, I, J, K, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L> Tuple12<B, C, D, E, F, G, H, I, J, K, L, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M> Tuple13<B, C, D, E, F, G, H, I, J, K, L, M, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple14<B, C, D, E, F, G, H, I, J, K, L, M, N, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple15<B, C, D, E, F, G, H, I, J, K, L, M, N, O, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple16<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple17<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple18<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple20<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, a);
	}
	
	public <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a);
	}
	
	public <RES> RES apply(Function1<A, RES> func)
	{
		return func.apply(a);
	}
	
	public void accept(Consumer1<A> consumer)
	{
		consumer.accept(a);
	}
	
	public @Override int arity()
	{
		return 1;
	}
	
	public @Override Stream<?> stream()
	{
		return Stream.of(a);
	}
	
	public Mutable1<A> mutable()
	{
		return new Mutable1<>(a);
	}
	
	public Tuple1<A> immutable()
	{
		return this;
	}
	
	public Tuple1<A> copy()
	{
		return new Tuple1<>(a);
	}
	
	public @Override String toString()
	{
		return "Tuple1" + stream().map(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
	}
	
	public @Override int hashCode()
	{
		return java.util.Objects.hash(a);
	}
	
	public @Override
	@SuppressWarnings("rawtypes") boolean equals(Object other)
	{
		if(!(other instanceof Tuple1 tuple)) return false;
		return tuple.arity() == arity() && Tuples.streamEquals(stream(), tuple.stream());
	}
	
	public static class Mutable1<A>
			extends Tuple1<A>
	{
		public Mutable1(A a)
		{
			super(a);
		}
		
		public @Override Mutable1<A> mutable()
		{
			return this;
		}
		
		public @Override Mutable1<A> copy()
		{
			return new Mutable1<>(a);
		}
		
		public @Override Tuple1<A> immutable()
		{
			return new Tuple1<>(a);
		}
		
		public @Override String toString()
		{
			return "Tuple1.Mutable1" + stream().map(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
		}
		
		public Mutable1<A> setA(A a)
		{
			this.a = a;
			return this;
		}
		
		
		public @Override <B> Tuple2.Mutable2<A, B> add(B b)
		{
			return Tuples.mutable(a, b);
		}
		
		public @Override <B, C> Tuple3.Mutable3<A, B, C> add(B b, C c)
		{
			return Tuples.mutable(a, b, c);
		}
		
		public @Override <B, C, D> Tuple4.Mutable4<A, B, C, D> add(B b, C c, D d)
		{
			return Tuples.mutable(a, b, c, d);
		}
		
		public @Override <B, C, D, E> Tuple5.Mutable5<A, B, C, D, E> add(B b, C c, D d, E e)
		{
			return Tuples.mutable(a, b, c, d, e);
		}
		
		public @Override <B, C, D, E, F> Tuple6.Mutable6<A, B, C, D, E, F> add(B b, C c, D d, E e, F f)
		{
			return Tuples.mutable(a, b, c, d, e, f);
		}
		
		public @Override <B, C, D, E, F, G> Tuple7.Mutable7<A, B, C, D, E, F, G> add(B b, C c, D d, E e, F f, G g)
		{
			return Tuples.mutable(a, b, c, d, e, f, g);
		}
		
		public @Override <B, C, D, E, F, G, H> Tuple8.Mutable8<A, B, C, D, E, F, G, H> add(B b, C c, D d, E e, F f, G g, H h)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h);
		}
		
		public @Override <B, C, D, E, F, G, H, I> Tuple9.Mutable9<A, B, C, D, E, F, G, H, I> add(B b, C c, D d, E e, F f, G g, H h, I i)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J> Tuple10.Mutable10<A, B, C, D, E, F, G, H, I, J> add(B b, C c, D d, E e, F f, G g, H h, I i, J j)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K> Tuple11.Mutable11<A, B, C, D, E, F, G, H, I, J, K> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L> Tuple12.Mutable12<A, B, C, D, E, F, G, H, I, J, K, L> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M> Tuple13.Mutable13<A, B, C, D, E, F, G, H, I, J, K, L, M> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple14.Mutable14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple15.Mutable15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple16.Mutable16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple17.Mutable17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple18.Mutable18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19.Mutable19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple20.Mutable20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21.Mutable21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22.Mutable22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23.Mutable23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24.Mutable24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25.Mutable25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26.Mutable26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> add(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
		}
		
		public @Override <B> Tuple2.Mutable2<B, A> insert(B b)
		{
			return Tuples.mutable(b, a);
		}
		
		public @Override <B, C> Tuple3.Mutable3<B, C, A> insert(B b, C c)
		{
			return Tuples.mutable(b, c, a);
		}
		
		public @Override <B, C, D> Tuple4.Mutable4<B, C, D, A> insert(B b, C c, D d)
		{
			return Tuples.mutable(b, c, d, a);
		}
		
		public @Override <B, C, D, E> Tuple5.Mutable5<B, C, D, E, A> insert(B b, C c, D d, E e)
		{
			return Tuples.mutable(b, c, d, e, a);
		}
		
		public @Override <B, C, D, E, F> Tuple6.Mutable6<B, C, D, E, F, A> insert(B b, C c, D d, E e, F f)
		{
			return Tuples.mutable(b, c, d, e, f, a);
		}
		
		public @Override <B, C, D, E, F, G> Tuple7.Mutable7<B, C, D, E, F, G, A> insert(B b, C c, D d, E e, F f, G g)
		{
			return Tuples.mutable(b, c, d, e, f, g, a);
		}
		
		public @Override <B, C, D, E, F, G, H> Tuple8.Mutable8<B, C, D, E, F, G, H, A> insert(B b, C c, D d, E e, F f, G g, H h)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I> Tuple9.Mutable9<B, C, D, E, F, G, H, I, A> insert(B b, C c, D d, E e, F f, G g, H h, I i)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J> Tuple10.Mutable10<B, C, D, E, F, G, H, I, J, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K> Tuple11.Mutable11<B, C, D, E, F, G, H, I, J, K, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L> Tuple12.Mutable12<B, C, D, E, F, G, H, I, J, K, L, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M> Tuple13.Mutable13<B, C, D, E, F, G, H, I, J, K, L, M, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple14.Mutable14<B, C, D, E, F, G, H, I, J, K, L, M, N, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple15.Mutable15<B, C, D, E, F, G, H, I, J, K, L, M, N, O, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple16.Mutable16<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple17.Mutable17<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple18.Mutable18<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19.Mutable19<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple20.Mutable20<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21.Mutable21<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22.Mutable22<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23.Mutable23<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24.Mutable24<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25.Mutable25<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, a);
		}
		
		public @Override <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26.Mutable26<B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A> insert(B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a);
		}
	}
}