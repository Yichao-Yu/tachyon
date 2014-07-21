package tachyon.r;

import java.io.IOException;

import tachyon.TachyonURI;
import tachyon.client.TachyonFS;

public abstract class ClientStoreBase extends StoreBase {
  protected ShardBase mShard;

  // TODO Use TachyonFS for now, create a new handler in the future.
  protected TachyonFS mTachyonFS;

  protected ClientStoreBase(TachyonURI uri, ShardBase shard, String storeType, boolean create)
      throws IOException {
    super(uri);

    mTachyonFS = TachyonFS.get(uri.toString());

    mShard = shard;

    if (create) {
      mTachyonFS.r_createStore(uri.getPath(), storeType);
    }
  }
}