package net.consensys.cava.io;

import java.io.IOException;

/**
 * Represents an operation that accepts a single input argument and returns no result.
 */
@FunctionalInterface
public interface IOConsumer<T> {

  /**
   * Performs this operation on the given argument.
   *
   * @param t the input argument
   * @throws IOException If an IO error occurs.
   */
  void accept(T t) throws IOException;
}
