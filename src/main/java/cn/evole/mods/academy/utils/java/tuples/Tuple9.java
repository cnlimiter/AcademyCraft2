package cn.evole.mods.academy.utils.java.tuples;

import org.zeith.hammerlib.util.java.consumers.*;
import org.zeith.hammerlib.util.java.functions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tuple9<A, B, C, D, E, F, G, H, I>
		implements ITuple
{
	protected A a;
	protected B b;
	protected C c;
	protected D d;
	protected E e;
	protected F f;
	protected G g;
	protected H h;
	protected I i;
	
	public Tuple9(A a, B b, C c, D d, E e, F f, G g, H h, I i)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
	}
	
	public A a()
	{
		return a;
	}
	
	public B b()
	{
		return b;
	}
	
	public C c()
	{
		return c;
	}
	
	public D d()
	{
		return d;
	}
	
	public E e()
	{
		return e;
	}
	
	public F f()
	{
		return f;
	}
	
	public G g()
	{
		return g;
	}
	
	public H h()
	{
		return h;
	}
	
	public I i()
	{
		return i;
	}
	
	public Tuple1<A> strip8R()
	{
		return Tuples.immutable(a);
	}
	
	public Tuple1<I> strip8L()
	{
		return Tuples.immutable(i);
	}
	
	public Tuple2<A, B> strip7R()
	{
		return Tuples.immutable(a, b);
	}
	
	public Tuple2<H, I> strip7L()
	{
		return Tuples.immutable(h, i);
	}
	
	public Tuple3<A, B, C> strip6R()
	{
		return Tuples.immutable(a, b, c);
	}
	
	public Tuple3<G, H, I> strip6L()
	{
		return Tuples.immutable(g, h, i);
	}
	
	public Tuple4<A, B, C, D> strip5R()
	{
		return Tuples.immutable(a, b, c, d);
	}
	
	public Tuple4<F, G, H, I> strip5L()
	{
		return Tuples.immutable(f, g, h, i);
	}
	
	public Tuple5<A, B, C, D, E> strip4R()
	{
		return Tuples.immutable(a, b, c, d, e);
	}
	
	public Tuple5<E, F, G, H, I> strip4L()
	{
		return Tuples.immutable(e, f, g, h, i);
	}
	
	public Tuple6<A, B, C, D, E, F> strip3R()
	{
		return Tuples.immutable(a, b, c, d, e, f);
	}
	
	public Tuple6<D, E, F, G, H, I> strip3L()
	{
		return Tuples.immutable(d, e, f, g, h, i);
	}
	
	public Tuple7<A, B, C, D, E, F, G> strip2R()
	{
		return Tuples.immutable(a, b, c, d, e, f, g);
	}
	
	public Tuple7<C, D, E, F, G, H, I> strip2L()
	{
		return Tuples.immutable(c, d, e, f, g, h, i);
	}
	
	public Tuple8<A, B, C, D, E, F, G, H> strip1R()
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h);
	}
	
	public Tuple8<B, C, D, E, F, G, H, I> strip1L()
	{
		return Tuples.immutable(b, c, d, e, f, g, h, i);
	}
	
	
	public <J> Tuple10<A, B, C, D, E, F, G, H, I, J> add(J j)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j);
	}
	
	public <J, K> Tuple11<A, B, C, D, E, F, G, H, I, J, K> add(J j, K k)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k);
	}
	
	public <J, K, L> Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> add(J j, K k, L l)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l);
	}
	
	public <J, K, L, M> Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M> add(J j, K k, L l, M m)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m);
	}
	
	public <J, K, L, M, N> Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> add(J j, K k, L l, M m, N n)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
	}
	
	public <J, K, L, M, N, O> Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> add(J j, K k, L l, M m, N n, O o)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
	}
	
	public <J, K, L, M, N, O, P> Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> add(J j, K k, L l, M m, N n, O o, P p)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
	}
	
	public <J, K, L, M, N, O, P, Q> Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> add(J j, K k, L l, M m, N n, O o, P p, Q q)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
	}
	
	public <J, K, L, M, N, O, P, Q, R> Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T> Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
	{
		return Tuples.immutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
	}
	
	public <J> Tuple10<J, A, B, C, D, E, F, G, H, I> insert(J j)
	{
		return Tuples.immutable(j, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K> Tuple11<J, K, A, B, C, D, E, F, G, H, I> insert(J j, K k)
	{
		return Tuples.immutable(j, k, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L> Tuple12<J, K, L, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l)
	{
		return Tuples.immutable(j, k, l, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M> Tuple13<J, K, L, M, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m)
	{
		return Tuples.immutable(j, k, l, m, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N> Tuple14<J, K, L, M, N, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n)
	{
		return Tuples.immutable(j, k, l, m, n, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O> Tuple15<J, K, L, M, N, O, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o)
	{
		return Tuples.immutable(j, k, l, m, n, o, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P> Tuple16<J, K, L, M, N, O, P, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q> Tuple17<J, K, L, M, N, O, P, Q, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R> Tuple18<J, K, L, M, N, O, P, Q, R, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S> Tuple19<J, K, L, M, N, O, P, Q, R, S, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T> Tuple20<J, K, L, M, N, O, P, Q, R, S, T, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21<J, K, L, M, N, O, P, Q, R, S, T, U, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22<J, K, L, M, N, O, P, Q, R, S, T, U, V, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, v, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, a, b, c, d, e, f, g, h, i);
	}
	
	public <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
	{
		return Tuples.immutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a, b, c, d, e, f, g, h, i);
	}
	
	public <RES> RES applyL(Function1<A, RES> func)
	{
		return func.apply(a);
	}
	
	public <RES> RES applyR(Function1<I, RES> func)
	{
		return func.apply(i);
	}
	
	public <RES> RES applyL(Function2<A, B, RES> func)
	{
		return func.apply(a, b);
	}
	
	public <RES> RES applyR(Function2<H, I, RES> func)
	{
		return func.apply(h, i);
	}
	
	public <RES> RES applyL(Function3<A, B, C, RES> func)
	{
		return func.apply(a, b, c);
	}
	
	public <RES> RES applyR(Function3<G, H, I, RES> func)
	{
		return func.apply(g, h, i);
	}
	
	public <RES> RES applyL(Function4<A, B, C, D, RES> func)
	{
		return func.apply(a, b, c, d);
	}
	
	public <RES> RES applyR(Function4<F, G, H, I, RES> func)
	{
		return func.apply(f, g, h, i);
	}
	
	public <RES> RES applyL(Function5<A, B, C, D, E, RES> func)
	{
		return func.apply(a, b, c, d, e);
	}
	
	public <RES> RES applyR(Function5<E, F, G, H, I, RES> func)
	{
		return func.apply(e, f, g, h, i);
	}
	
	public <RES> RES applyL(Function6<A, B, C, D, E, F, RES> func)
	{
		return func.apply(a, b, c, d, e, f);
	}
	
	public <RES> RES applyR(Function6<D, E, F, G, H, I, RES> func)
	{
		return func.apply(d, e, f, g, h, i);
	}
	
	public <RES> RES applyL(Function7<A, B, C, D, E, F, G, RES> func)
	{
		return func.apply(a, b, c, d, e, f, g);
	}
	
	public <RES> RES applyR(Function7<C, D, E, F, G, H, I, RES> func)
	{
		return func.apply(c, d, e, f, g, h, i);
	}
	
	public <RES> RES applyL(Function8<A, B, C, D, E, F, G, H, RES> func)
	{
		return func.apply(a, b, c, d, e, f, g, h);
	}
	
	public <RES> RES applyR(Function8<B, C, D, E, F, G, H, I, RES> func)
	{
		return func.apply(b, c, d, e, f, g, h, i);
	}
	
	public <RES> RES apply(Function9<A, B, C, D, E, F, G, H, I, RES> func)
	{
		return func.apply(a, b, c, d, e, f, g, h, i);
	}
	
	public void acceptL(Consumer1<A> consumer)
	{
		consumer.accept(a);
	}
	
	public void acceptR(Consumer1<I> consumer)
	{
		consumer.accept(i);
	}
	
	public void acceptL(Consumer2<A, B> consumer)
	{
		consumer.accept(a, b);
	}
	
	public void acceptR(Consumer2<H, I> consumer)
	{
		consumer.accept(h, i);
	}
	
	public void acceptL(Consumer3<A, B, C> consumer)
	{
		consumer.accept(a, b, c);
	}
	
	public void acceptR(Consumer3<G, H, I> consumer)
	{
		consumer.accept(g, h, i);
	}
	
	public void acceptL(Consumer4<A, B, C, D> consumer)
	{
		consumer.accept(a, b, c, d);
	}
	
	public void acceptR(Consumer4<F, G, H, I> consumer)
	{
		consumer.accept(f, g, h, i);
	}
	
	public void acceptL(Consumer5<A, B, C, D, E> consumer)
	{
		consumer.accept(a, b, c, d, e);
	}
	
	public void acceptR(Consumer5<E, F, G, H, I> consumer)
	{
		consumer.accept(e, f, g, h, i);
	}
	
	public void acceptL(Consumer6<A, B, C, D, E, F> consumer)
	{
		consumer.accept(a, b, c, d, e, f);
	}
	
	public void acceptR(Consumer6<D, E, F, G, H, I> consumer)
	{
		consumer.accept(d, e, f, g, h, i);
	}
	
	public void acceptL(Consumer7<A, B, C, D, E, F, G> consumer)
	{
		consumer.accept(a, b, c, d, e, f, g);
	}
	
	public void acceptR(Consumer7<C, D, E, F, G, H, I> consumer)
	{
		consumer.accept(c, d, e, f, g, h, i);
	}
	
	public void acceptL(Consumer8<A, B, C, D, E, F, G, H> consumer)
	{
		consumer.accept(a, b, c, d, e, f, g, h);
	}
	
	public void acceptR(Consumer8<B, C, D, E, F, G, H, I> consumer)
	{
		consumer.accept(b, c, d, e, f, g, h, i);
	}
	
	public void accept(Consumer9<A, B, C, D, E, F, G, H, I> consumer)
	{
		consumer.accept(a, b, c, d, e, f, g, h, i);
	}
	
	public @Override int arity()
	{
		return 9;
	}
	
	public @Override Stream<?> stream()
	{
		return Stream.of(a, b, c, d, e, f, g, h, i);
	}
	
	public Mutable9<A, B, C, D, E, F, G, H, I> mutable()
	{
		return new Mutable9<>(a, b, c, d, e, f, g, h, i);
	}
	
	public Tuple9<A, B, C, D, E, F, G, H, I> immutable()
	{
		return this;
	}
	
	public Tuple9<A, B, C, D, E, F, G, H, I> copy()
	{
		return new Tuple9<>(a, b, c, d, e, f, g, h, i);
	}
	
	public @Override String toString()
	{
		return "Tuple9" + stream().map(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
	}
	
	public @Override int hashCode()
	{
		return java.util.Objects.hash(a, b, c, d, e, f, g, h, i);
	}
	
	public @Override
	@SuppressWarnings("rawtypes") boolean equals(Object other)
	{
		if(!(other instanceof Tuple9 tuple)) return false;
		return tuple.arity() == arity() && Tuples.streamEquals(stream(), tuple.stream());
	}
	
	public static class Mutable9<A, B, C, D, E, F, G, H, I>
			extends Tuple9<A, B, C, D, E, F, G, H, I>
	{
		public Mutable9(A a, B b, C c, D d, E e, F f, G g, H h, I i)
		{
			super(a, b, c, d, e, f, g, h, i);
		}
		
		public @Override Mutable9<A, B, C, D, E, F, G, H, I> mutable()
		{
			return this;
		}
		
		public @Override Mutable9<A, B, C, D, E, F, G, H, I> copy()
		{
			return new Mutable9<>(a, b, c, d, e, f, g, h, i);
		}
		
		public @Override Tuple9<A, B, C, D, E, F, G, H, I> immutable()
		{
			return new Tuple9<>(a, b, c, d, e, f, g, h, i);
		}
		
		public @Override String toString()
		{
			return "Tuple9.Mutable9" + stream().map(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setA(A a)
		{
			this.a = a;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setB(B b)
		{
			this.b = b;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setC(C c)
		{
			this.c = c;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setD(D d)
		{
			this.d = d;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setE(E e)
		{
			this.e = e;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setF(F f)
		{
			this.f = f;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setG(G g)
		{
			this.g = g;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setH(H h)
		{
			this.h = h;
			return this;
		}
		
		public Mutable9<A, B, C, D, E, F, G, H, I> setI(I i)
		{
			this.i = i;
			return this;
		}
		
		public @Override Tuple1.Mutable1<A> strip8R()
		{
			return Tuples.mutable(a);
		}
		
		public @Override Tuple1.Mutable1<I> strip8L()
		{
			return Tuples.mutable(i);
		}
		
		public @Override Tuple2.Mutable2<A, B> strip7R()
		{
			return Tuples.mutable(a, b);
		}
		
		public @Override Tuple2.Mutable2<H, I> strip7L()
		{
			return Tuples.mutable(h, i);
		}
		
		public @Override Tuple3.Mutable3<A, B, C> strip6R()
		{
			return Tuples.mutable(a, b, c);
		}
		
		public @Override Tuple3.Mutable3<G, H, I> strip6L()
		{
			return Tuples.mutable(g, h, i);
		}
		
		public @Override Tuple4.Mutable4<A, B, C, D> strip5R()
		{
			return Tuples.mutable(a, b, c, d);
		}
		
		public @Override Tuple4.Mutable4<F, G, H, I> strip5L()
		{
			return Tuples.mutable(f, g, h, i);
		}
		
		public @Override Tuple5.Mutable5<A, B, C, D, E> strip4R()
		{
			return Tuples.mutable(a, b, c, d, e);
		}
		
		public @Override Tuple5.Mutable5<E, F, G, H, I> strip4L()
		{
			return Tuples.mutable(e, f, g, h, i);
		}
		
		public @Override Tuple6.Mutable6<A, B, C, D, E, F> strip3R()
		{
			return Tuples.mutable(a, b, c, d, e, f);
		}
		
		public @Override Tuple6.Mutable6<D, E, F, G, H, I> strip3L()
		{
			return Tuples.mutable(d, e, f, g, h, i);
		}
		
		public @Override Tuple7.Mutable7<A, B, C, D, E, F, G> strip2R()
		{
			return Tuples.mutable(a, b, c, d, e, f, g);
		}
		
		public @Override Tuple7.Mutable7<C, D, E, F, G, H, I> strip2L()
		{
			return Tuples.mutable(c, d, e, f, g, h, i);
		}
		
		public @Override Tuple8.Mutable8<A, B, C, D, E, F, G, H> strip1R()
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h);
		}
		
		public @Override Tuple8.Mutable8<B, C, D, E, F, G, H, I> strip1L()
		{
			return Tuples.mutable(b, c, d, e, f, g, h, i);
		}
		
		public @Override <J> Tuple10.Mutable10<A, B, C, D, E, F, G, H, I, J> add(J j)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j);
		}
		
		public @Override <J, K> Tuple11.Mutable11<A, B, C, D, E, F, G, H, I, J, K> add(J j, K k)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k);
		}
		
		public @Override <J, K, L> Tuple12.Mutable12<A, B, C, D, E, F, G, H, I, J, K, L> add(J j, K k, L l)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l);
		}
		
		public @Override <J, K, L, M> Tuple13.Mutable13<A, B, C, D, E, F, G, H, I, J, K, L, M> add(J j, K k, L l, M m)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m);
		}
		
		public @Override <J, K, L, M, N> Tuple14.Mutable14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> add(J j, K k, L l, M m, N n)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
		}
		
		public @Override <J, K, L, M, N, O> Tuple15.Mutable15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> add(J j, K k, L l, M m, N n, O o)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
		}
		
		public @Override <J, K, L, M, N, O, P> Tuple16.Mutable16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> add(J j, K k, L l, M m, N n, O o, P p)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
		}
		
		public @Override <J, K, L, M, N, O, P, Q> Tuple17.Mutable17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> add(J j, K k, L l, M m, N n, O o, P p, Q q)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R> Tuple18.Mutable18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S> Tuple19.Mutable19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T> Tuple20.Mutable20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21.Mutable21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22.Mutable22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23.Mutable23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24.Mutable24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25.Mutable25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26.Mutable26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> add(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
		{
			return Tuples.mutable(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
		}
		
		public @Override <J> Tuple10.Mutable10<J, A, B, C, D, E, F, G, H, I> insert(J j)
		{
			return Tuples.mutable(j, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K> Tuple11.Mutable11<J, K, A, B, C, D, E, F, G, H, I> insert(J j, K k)
		{
			return Tuples.mutable(j, k, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L> Tuple12.Mutable12<J, K, L, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l)
		{
			return Tuples.mutable(j, k, l, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M> Tuple13.Mutable13<J, K, L, M, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m)
		{
			return Tuples.mutable(j, k, l, m, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N> Tuple14.Mutable14<J, K, L, M, N, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n)
		{
			return Tuples.mutable(j, k, l, m, n, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O> Tuple15.Mutable15<J, K, L, M, N, O, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o)
		{
			return Tuples.mutable(j, k, l, m, n, o, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P> Tuple16.Mutable16<J, K, L, M, N, O, P, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q> Tuple17.Mutable17<J, K, L, M, N, O, P, Q, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R> Tuple18.Mutable18<J, K, L, M, N, O, P, Q, R, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S> Tuple19.Mutable19<J, K, L, M, N, O, P, Q, R, S, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T> Tuple20.Mutable20<J, K, L, M, N, O, P, Q, R, S, T, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21.Mutable21<J, K, L, M, N, O, P, Q, R, S, T, U, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22.Mutable22<J, K, L, M, N, O, P, Q, R, S, T, U, V, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, v, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple23.Mutable23<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple24.Mutable24<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple25.Mutable25<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, a, b, c, d, e, f, g, h, i);
		}
		
		public @Override <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple26.Mutable26<J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A, B, C, D, E, F, G, H, I> insert(J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u, V v, W w, X x, Y y, Z z)
		{
			return Tuples.mutable(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a, b, c, d, e, f, g, h, i);
		}
	}
}