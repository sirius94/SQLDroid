package org.sqldroid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class SQLDroidBlob implements Blob {

	private static final Logger LOGGER = LoggerFactory.getLogger(SQLDroidBlob.class);

	byte [] b;
	
	public SQLDroidBlob(byte [] b) {
		this.b = b;
	}
	
	@Override
	public InputStream getBinaryStream() throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return null;
	}

	@Override
	public byte[] getBytes(long pos, int length) throws SQLException {
		return b;
	}

	@Override
	public long length() throws SQLException {
		return b.length;
	}

	@Override
	public long position(Blob pattern, long start) throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return 0;
	}

	@Override
	public long position(byte[] pattern, long start) throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return 0;
	}

	@Override
	public OutputStream setBinaryStream(long pos) throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return null;
	}

	@Override
	public int setBytes(long pos, byte[] theBytes) throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return 0;
	}

	@Override
	public int setBytes(long pos, byte[] theBytes, int offset, int len)
			throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());
		return 0;
	}

	@Override
	public void truncate(long len) throws SQLException {
		LOGGER.warn(" ********************* not implemented @ " + DebugPrinter.getFileName() + " line " + DebugPrinter.getLineNumber());

	}

	@Override
	public void free() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputStream getBinaryStream(long pos, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

  /** Print the length of the blob along with the first 10 characters.
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    if ( b == null ) {
      sb.append("Null Blob");
    }
    sb.append ("Blob length ");
    long length = 0;
    try {
      length = length();
    } catch (SQLException e) {
      // never thrown
    }
    sb.append (length);
    sb.append(" ");
    if ( length > 10 ) {
      length = 10;
    }
    for ( int counter = 0 ; counter < length ; counter++ ) {
      sb.append ("0x");
      sb.append (Integer.toHexString(b[counter]));
      sb.append(" ");
    }
    sb.append("(");
    for ( int counter = 0 ; counter < length ; counter++ ) {
      sb.append (Character.toString((char)b[counter]));
      if ( counter == length-1 ) {
        sb.append(")");
      } else {
        sb.append(" ");
      }
    }
    return sb.toString();
  }


}
