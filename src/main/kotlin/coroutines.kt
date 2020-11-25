import kotlinx.coroutines.*

class SampleCoroutines {
  fun compute1(n: Int): Int {
    return n * 2
  }

  suspend fun compute2(n: Int): Int {
    return n * 2
  }
}

//kotlinc-jvm -classpath /opt/kotlin/kotlinx-coroutines-core-1.1.1.jar sample.kt
//javap -c Sample.class

/*
At the bytecode level we see this:
public final int compute1(int);

public final java.lang.Object compute2(
		int, kotlin.coroutines.Continuation<? super java.lang.Integer>);

Compiler does a lot of syntax sugar to support continuations.
*/