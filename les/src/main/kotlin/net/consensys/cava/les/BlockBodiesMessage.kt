/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package net.consensys.cava.les

import net.consensys.cava.bytes.Bytes
import net.consensys.cava.eth.BlockBody
import net.consensys.cava.rlp.RLP

internal data class BlockBodiesMessage(
  val reqID: Long,
  val bufferValue: Long,
  val blockBodies: List<BlockBody>
) {

  fun toBytes(): Bytes {
    return RLP.encodeList { writer ->
      writer.writeLong(reqID)
      writer.writeLong(bufferValue)
      writer.writeList(blockBodies) { eltWriter, blockBody -> blockBody.writeTo(eltWriter) }
    }
  }

  companion object {

    fun read(bytes: Bytes): BlockBodiesMessage {
      return RLP.decodeList(
        bytes
      ) { reader ->
        BlockBodiesMessage(
          reader.readLong(),
          reader.readLong(),
          reader.readListContents { BlockBody.readFrom(it) }
        )
      }
    }
  }
}
