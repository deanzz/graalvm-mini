package graalvm.mini

object Main {

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    val res = (0 to 500000).flatMap(i => fibSeq(i.toLong)).sum
    val end = System.currentTimeMillis()
    println(s"res = $res, used ${end - start}ms")
  }

  def fibSeq(n: Long): List[Long] = {
    var ret = scala.collection.mutable.ListBuffer[Long](1, 2)
    while (ret.last < n) {
      val temp = ret.last + ret(ret.length - 2)
      if (temp >= n) {
        return ret.toList
      }
      ret += temp
    }
    ret.toList
  }
}
