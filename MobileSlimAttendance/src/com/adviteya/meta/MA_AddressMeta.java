package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:12")
/** */
public final class MA_AddressMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Address> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> city = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "city", "city");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Address, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Address, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.adviteya.model.MA_Address, com.google.appengine.api.datastore.Email> emailAddress = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.adviteya.model.MA_Address, com.google.appengine.api.datastore.Email>(this, "emailAddress", "emailAddress", com.google.appengine.api.datastore.Email.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> line1 = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "line1", "line1");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> line2 = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "line2", "line2");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> nonStandardState = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "nonStandardState", "nonStandardState");

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.adviteya.model.MA_Address, com.adviteya.model.MA_PhoneNumber[]> officePhone = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.adviteya.model.MA_Address, com.adviteya.model.MA_PhoneNumber[]>(this, "officePhone", "officePhone", com.adviteya.model.MA_PhoneNumber[].class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> pinCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "pinCode", "pinCode");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Address, org.slim3.datastore.ModelRef<com.adviteya.model.MA_State>, com.adviteya.model.MA_State> stateRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Address, org.slim3.datastore.ModelRef<com.adviteya.model.MA_State>, com.adviteya.model.MA_State>(this, "stateRef", "stateRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_State.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> timeZone = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "timeZone", "timeZone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Address>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Address, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_AddressMeta slim3_singleton = new MA_AddressMeta();

    /**
     * @return the singleton
     */
    public static MA_AddressMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_AddressMeta() {
        super("MA_Address", com.adviteya.model.MA_Address.class);
    }

    @Override
    public com.adviteya.model.MA_Address entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Address model = new com.adviteya.model.MA_Address();
        model.setCity((java.lang.String) entity.getProperty("city"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setEmailAddress((com.google.appengine.api.datastore.Email) entity.getProperty("emailAddress"));
        model.setLine1((java.lang.String) entity.getProperty("line1"));
        model.setLine2((java.lang.String) entity.getProperty("line2"));
        model.setNonStandardState((java.lang.String) entity.getProperty("nonStandardState"));
        com.adviteya.model.MA_PhoneNumber[] _officePhone = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("officePhone"));
        model.setOfficePhone(_officePhone);
        model.setPinCode((java.lang.String) entity.getProperty("pinCode"));
        if (model.getStateRef() == null) {
            throw new NullPointerException("The property(stateRef) is null.");
        }
        model.getStateRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("stateRef"));
        model.setTimeZone((java.lang.String) entity.getProperty("timeZone"));
        model.setCreatedBy((java.lang.String) entity.getProperty("createdBy"));
        model.setCreatedDate((java.util.Date) entity.getProperty("createdDate"));
        model.setKey(entity.getKey());
        model.setUpdatedBy((java.lang.String) entity.getProperty("updatedBy"));
        model.setUpdatedDate((java.util.Date) entity.getProperty("updatedDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("city", m.getCity());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setUnindexedProperty("emailAddress", m.getEmailAddress());
        entity.setProperty("line1", m.getLine1());
        entity.setProperty("line2", m.getLine2());
        entity.setProperty("nonStandardState", m.getNonStandardState());
        entity.setUnindexedProperty("officePhone", serializableToBlob(m.getOfficePhone()));
        entity.setProperty("pinCode", m.getPinCode());
        if (m.getStateRef() == null) {
            throw new NullPointerException("The property(stateRef) must not be null.");
        }
        entity.setProperty("stateRef", m.getStateRef().getKey());
        entity.setProperty("timeZone", m.getTimeZone());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getStateRef() == null) {
            throw new NullPointerException("The property(stateRef) must not be null.");
        }
        m.getStateRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        m.setCreatedDate(slim3_createdDateAttributeListener.prePut(m.getCreatedDate()));
        m.setUpdatedDate(slim3_updatedDateAttributeListener.prePut(m.getUpdatedDate()));
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Address m = (com.adviteya.model.MA_Address) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCity() != null){
            writer.setNextPropertyName("city");
            encoder0.encode(writer, m.getCity());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getEmailAddress() != null){
            writer.setNextPropertyName("emailAddress");
            encoder0.encode(writer, m.getEmailAddress());
        }
        if(m.getLine1() != null){
            writer.setNextPropertyName("line1");
            encoder0.encode(writer, m.getLine1());
        }
        if(m.getLine2() != null){
            writer.setNextPropertyName("line2");
            encoder0.encode(writer, m.getLine2());
        }
        if(m.getNonStandardState() != null){
            writer.setNextPropertyName("nonStandardState");
            encoder0.encode(writer, m.getNonStandardState());
        }
        if(m.getOfficePhone() != null){
            writer.setNextPropertyName("officePhone");
            // com.adviteya.model.MA_PhoneNumber[](com.adviteya.model.MA_PhoneNumber[]) is not supported.
        }
        if(m.getPinCode() != null){
            writer.setNextPropertyName("pinCode");
            encoder0.encode(writer, m.getPinCode());
        }
        if(m.getStateRef() != null && m.getStateRef().getKey() != null){
            writer.setNextPropertyName("stateRef");
            encoder0.encode(writer, m.getStateRef(), maxDepth, currentDepth);
        }
        if(m.getTimeZone() != null){
            writer.setNextPropertyName("timeZone");
            encoder0.encode(writer, m.getTimeZone());
        }
        if(m.getCreatedBy() != null){
            writer.setNextPropertyName("createdBy");
            encoder0.encode(writer, m.getCreatedBy());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getUpdatedBy() != null){
            writer.setNextPropertyName("updatedBy");
            encoder0.encode(writer, m.getUpdatedBy());
        }
        if(m.getUpdatedDate() != null){
            writer.setNextPropertyName("updatedDate");
            encoder0.encode(writer, m.getUpdatedDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.adviteya.model.MA_Address jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Address m = new com.adviteya.model.MA_Address();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("city");
        m.setCity(decoder0.decode(reader, m.getCity()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("emailAddress");
        m.setEmailAddress(decoder0.decode(reader, m.getEmailAddress()));
        reader = rootReader.newObjectReader("line1");
        m.setLine1(decoder0.decode(reader, m.getLine1()));
        reader = rootReader.newObjectReader("line2");
        m.setLine2(decoder0.decode(reader, m.getLine2()));
        reader = rootReader.newObjectReader("nonStandardState");
        m.setNonStandardState(decoder0.decode(reader, m.getNonStandardState()));
        reader = rootReader.newObjectReader("officePhone");
        // com.adviteya.model.MA_PhoneNumber[](com.adviteya.model.MA_PhoneNumber[]) is not supported.
        reader = rootReader.newObjectReader("pinCode");
        m.setPinCode(decoder0.decode(reader, m.getPinCode()));
        reader = rootReader.newObjectReader("stateRef");
        decoder0.decode(reader, m.getStateRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("timeZone");
        m.setTimeZone(decoder0.decode(reader, m.getTimeZone()));
        reader = rootReader.newObjectReader("createdBy");
        m.setCreatedBy(decoder0.decode(reader, m.getCreatedBy()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("updatedBy");
        m.setUpdatedBy(decoder0.decode(reader, m.getUpdatedBy()));
        reader = rootReader.newObjectReader("updatedDate");
        m.setUpdatedDate(decoder0.decode(reader, m.getUpdatedDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}