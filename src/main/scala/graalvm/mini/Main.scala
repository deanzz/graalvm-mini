package graalvm.mini

object Main {
  private val runtime = Runtime.getRuntime()
  import runtime.{ totalMemory, freeMemory, maxMemory }

  def main(args: Array[String]): Unit = {

    val start = System.currentTimeMillis()
    val res = (0 to 500000).foldLeft(0L){
      case (sum, i) =>
        val s = fibSeq(i.toLong)
        val r = sum + s.sum
        val total = totalMemory.toDouble / 1024 / 1024
        val free = freeMemory.toDouble / 1024 / 1024
        if (i % 100000 == 0) println(s"total memory = ${total}MB, freeMemory = ${free}MB, usedMemory = ${total - free}MB")
        r
    }
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
