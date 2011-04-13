/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2011, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala.collection
package mutable


import generic._


/** A subtrait of `collection.GenSeq` which represents sequences
 *  that can be mutated.
 *
 *  $possiblyparinfo
 *
 *  $seqInfo
 *
 *  The class adds an `update` method to `collection.Seq`.
 *
 *  @define Coll mutable.Seq
 *  @define coll mutable sequence
 */
trait GenSeq[A] extends GenIterable[A]
                        with scala.collection.GenSeq[A]
                        with scala.collection.GenSeqLike[A, GenSeq[A]]
                        with GenericTraversableTemplate[A, GenSeq]
{
  override def companion: GenericCompanion[GenSeq] = GenSeq
  def seq: Seq[A]
}


object GenSeq extends SeqFactory[GenSeq] {
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, GenSeq[A]] = new GenericCanBuildFrom[A]
  def newBuilder[A]: Builder[A, GenSeq[A]] = Seq.newBuilder
}
