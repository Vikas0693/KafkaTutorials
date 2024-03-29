package com.crypto.schema.avro;
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EntitySentiment extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7206386309650251468L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EntitySentiment\",\"fields\":[{\"name\":\"created_at\",\"type\":\"long\"},{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"entity\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"text\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sentiment_score\",\"type\":\"double\"},{\"name\":\"sentiment_magnitude\",\"type\":\"double\"},{\"name\":\"salience\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EntitySentiment> ENCODER =
      new BinaryMessageEncoder<EntitySentiment>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EntitySentiment> DECODER =
      new BinaryMessageDecoder<EntitySentiment>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EntitySentiment> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EntitySentiment> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EntitySentiment> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EntitySentiment>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EntitySentiment to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EntitySentiment from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EntitySentiment instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EntitySentiment fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long created_at;
  private long id;
  private java.lang.String entity;
  private java.lang.String text;
  private double sentiment_score;
  private double sentiment_magnitude;
  private double salience;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EntitySentiment() {}

  /**
   * All-args constructor.
   * @param created_at The new value for created_at
   * @param id The new value for id
   * @param entity The new value for entity
   * @param text The new value for text
   * @param sentiment_score The new value for sentiment_score
   * @param sentiment_magnitude The new value for sentiment_magnitude
   * @param salience The new value for salience
   */
  public EntitySentiment(java.lang.Long created_at, java.lang.Long id, java.lang.String entity, java.lang.String text, java.lang.Double sentiment_score, java.lang.Double sentiment_magnitude, java.lang.Double salience) {
    this.created_at = created_at;
    this.id = id;
    this.entity = entity;
    this.text = text;
    this.sentiment_score = sentiment_score;
    this.sentiment_magnitude = sentiment_magnitude;
    this.salience = salience;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return created_at;
    case 1: return id;
    case 2: return entity;
    case 3: return text;
    case 4: return sentiment_score;
    case 5: return sentiment_magnitude;
    case 6: return salience;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: created_at = (java.lang.Long)value$; break;
    case 1: id = (java.lang.Long)value$; break;
    case 2: entity = value$ != null ? value$.toString() : null; break;
    case 3: text = value$ != null ? value$.toString() : null; break;
    case 4: sentiment_score = (java.lang.Double)value$; break;
    case 5: sentiment_magnitude = (java.lang.Double)value$; break;
    case 6: salience = (java.lang.Double)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'created_at' field.
   * @return The value of the 'created_at' field.
   */
  public long getCreatedAt() {
    return created_at;
  }


  /**
   * Sets the value of the 'created_at' field.
   * @param value the value to set.
   */
  public void setCreatedAt(long value) {
    this.created_at = value;
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public long getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'entity' field.
   * @return The value of the 'entity' field.
   */
  public java.lang.String getEntity() {
    return entity;
  }


  /**
   * Sets the value of the 'entity' field.
   * @param value the value to set.
   */
  public void setEntity(java.lang.String value) {
    this.entity = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.String getText() {
    return text;
  }


  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.String value) {
    this.text = value;
  }

  /**
   * Gets the value of the 'sentiment_score' field.
   * @return The value of the 'sentiment_score' field.
   */
  public double getSentimentScore() {
    return sentiment_score;
  }


  /**
   * Sets the value of the 'sentiment_score' field.
   * @param value the value to set.
   */
  public void setSentimentScore(double value) {
    this.sentiment_score = value;
  }

  /**
   * Gets the value of the 'sentiment_magnitude' field.
   * @return The value of the 'sentiment_magnitude' field.
   */
  public double getSentimentMagnitude() {
    return sentiment_magnitude;
  }


  /**
   * Sets the value of the 'sentiment_magnitude' field.
   * @param value the value to set.
   */
  public void setSentimentMagnitude(double value) {
    this.sentiment_magnitude = value;
  }

  /**
   * Gets the value of the 'salience' field.
   * @return The value of the 'salience' field.
   */
  public double getSalience() {
    return salience;
  }


  /**
   * Sets the value of the 'salience' field.
   * @param value the value to set.
   */
  public void setSalience(double value) {
    this.salience = value;
  }

  /**
   * Creates a new EntitySentiment RecordBuilder.
   * @return A new EntitySentiment RecordBuilder
   */
  public static EntitySentiment.Builder newBuilder() {
    return new EntitySentiment.Builder();
  }

  /**
   * Creates a new EntitySentiment RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EntitySentiment RecordBuilder
   */
  public static EntitySentiment.Builder newBuilder(EntitySentiment.Builder other) {
    if (other == null) {
      return new EntitySentiment.Builder();
    } else {
      return new EntitySentiment.Builder(other);
    }
  }

  /**
   * Creates a new EntitySentiment RecordBuilder by copying an existing EntitySentiment instance.
   * @param other The existing instance to copy.
   * @return A new EntitySentiment RecordBuilder
   */
  public static EntitySentiment.Builder newBuilder(EntitySentiment other) {
    if (other == null) {
      return new EntitySentiment.Builder();
    } else {
      return new EntitySentiment.Builder(other);
    }
  }

  /**
   * RecordBuilder for EntitySentiment instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EntitySentiment>
    implements org.apache.avro.data.RecordBuilder<EntitySentiment> {

    private long created_at;
    private long id;
    private java.lang.String entity;
    private java.lang.String text;
    private double sentiment_score;
    private double sentiment_magnitude;
    private double salience;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(EntitySentiment.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.created_at)) {
        this.created_at = data().deepCopy(fields()[0].schema(), other.created_at);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.entity)) {
        this.entity = data().deepCopy(fields()[2].schema(), other.entity);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.text)) {
        this.text = data().deepCopy(fields()[3].schema(), other.text);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.sentiment_score)) {
        this.sentiment_score = data().deepCopy(fields()[4].schema(), other.sentiment_score);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.sentiment_magnitude)) {
        this.sentiment_magnitude = data().deepCopy(fields()[5].schema(), other.sentiment_magnitude);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.salience)) {
        this.salience = data().deepCopy(fields()[6].schema(), other.salience);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing EntitySentiment instance
     * @param other The existing instance to copy.
     */
    private Builder(EntitySentiment other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.created_at)) {
        this.created_at = data().deepCopy(fields()[0].schema(), other.created_at);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.entity)) {
        this.entity = data().deepCopy(fields()[2].schema(), other.entity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.text)) {
        this.text = data().deepCopy(fields()[3].schema(), other.text);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.sentiment_score)) {
        this.sentiment_score = data().deepCopy(fields()[4].schema(), other.sentiment_score);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.sentiment_magnitude)) {
        this.sentiment_magnitude = data().deepCopy(fields()[5].schema(), other.sentiment_magnitude);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.salience)) {
        this.salience = data().deepCopy(fields()[6].schema(), other.salience);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'created_at' field.
      * @return The value.
      */
    public long getCreatedAt() {
      return created_at;
    }


    /**
      * Sets the value of the 'created_at' field.
      * @param value The value of 'created_at'.
      * @return This builder.
      */
    public EntitySentiment.Builder setCreatedAt(long value) {
      validate(fields()[0], value);
      this.created_at = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'created_at' field has been set.
      * @return True if the 'created_at' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'created_at' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearCreatedAt() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public long getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public EntitySentiment.Builder setId(long value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'entity' field.
      * @return The value.
      */
    public java.lang.String getEntity() {
      return entity;
    }


    /**
      * Sets the value of the 'entity' field.
      * @param value The value of 'entity'.
      * @return This builder.
      */
    public EntitySentiment.Builder setEntity(java.lang.String value) {
      validate(fields()[2], value);
      this.entity = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'entity' field has been set.
      * @return True if the 'entity' field has been set, false otherwise.
      */
    public boolean hasEntity() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'entity' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearEntity() {
      entity = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.String getText() {
      return text;
    }


    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public EntitySentiment.Builder setText(java.lang.String value) {
      validate(fields()[3], value);
      this.text = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearText() {
      text = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'sentiment_score' field.
      * @return The value.
      */
    public double getSentimentScore() {
      return sentiment_score;
    }


    /**
      * Sets the value of the 'sentiment_score' field.
      * @param value The value of 'sentiment_score'.
      * @return This builder.
      */
    public EntitySentiment.Builder setSentimentScore(double value) {
      validate(fields()[4], value);
      this.sentiment_score = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'sentiment_score' field has been set.
      * @return True if the 'sentiment_score' field has been set, false otherwise.
      */
    public boolean hasSentimentScore() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'sentiment_score' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearSentimentScore() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'sentiment_magnitude' field.
      * @return The value.
      */
    public double getSentimentMagnitude() {
      return sentiment_magnitude;
    }


    /**
      * Sets the value of the 'sentiment_magnitude' field.
      * @param value The value of 'sentiment_magnitude'.
      * @return This builder.
      */
    public EntitySentiment.Builder setSentimentMagnitude(double value) {
      validate(fields()[5], value);
      this.sentiment_magnitude = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'sentiment_magnitude' field has been set.
      * @return True if the 'sentiment_magnitude' field has been set, false otherwise.
      */
    public boolean hasSentimentMagnitude() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'sentiment_magnitude' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearSentimentMagnitude() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'salience' field.
      * @return The value.
      */
    public double getSalience() {
      return salience;
    }


    /**
      * Sets the value of the 'salience' field.
      * @param value The value of 'salience'.
      * @return This builder.
      */
    public EntitySentiment.Builder setSalience(double value) {
      validate(fields()[6], value);
      this.salience = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'salience' field has been set.
      * @return True if the 'salience' field has been set, false otherwise.
      */
    public boolean hasSalience() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'salience' field.
      * @return This builder.
      */
    public EntitySentiment.Builder clearSalience() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EntitySentiment build() {
      try {
        EntitySentiment record = new EntitySentiment();
        record.created_at = fieldSetFlags()[0] ? this.created_at : (java.lang.Long) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.Long) defaultValue(fields()[1]);
        record.entity = fieldSetFlags()[2] ? this.entity : (java.lang.String) defaultValue(fields()[2]);
        record.text = fieldSetFlags()[3] ? this.text : (java.lang.String) defaultValue(fields()[3]);
        record.sentiment_score = fieldSetFlags()[4] ? this.sentiment_score : (java.lang.Double) defaultValue(fields()[4]);
        record.sentiment_magnitude = fieldSetFlags()[5] ? this.sentiment_magnitude : (java.lang.Double) defaultValue(fields()[5]);
        record.salience = fieldSetFlags()[6] ? this.salience : (java.lang.Double) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EntitySentiment>
    WRITER$ = (org.apache.avro.io.DatumWriter<EntitySentiment>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EntitySentiment>
    READER$ = (org.apache.avro.io.DatumReader<EntitySentiment>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.created_at);

    out.writeLong(this.id);

    out.writeString(this.entity);

    out.writeString(this.text);

    out.writeDouble(this.sentiment_score);

    out.writeDouble(this.sentiment_magnitude);

    out.writeDouble(this.salience);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.created_at = in.readLong();

      this.id = in.readLong();

      this.entity = in.readString();

      this.text = in.readString();

      this.sentiment_score = in.readDouble();

      this.sentiment_magnitude = in.readDouble();

      this.salience = in.readDouble();

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.created_at = in.readLong();
          break;

        case 1:
          this.id = in.readLong();
          break;

        case 2:
          this.entity = in.readString();
          break;

        case 3:
          this.text = in.readString();
          break;

        case 4:
          this.sentiment_score = in.readDouble();
          break;

        case 5:
          this.sentiment_magnitude = in.readDouble();
          break;

        case 6:
          this.salience = in.readDouble();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }

  @Override
  public String toString() {
	  return "EntitySentiment [created_at=" + created_at + ", id=" + id + ", entity=" + entity + ", text=" + text
			  + ", sentiment_score=" + sentiment_score + ", sentiment_magnitude=" + sentiment_magnitude + ", salience="
			  + salience + "]";
  }


}










