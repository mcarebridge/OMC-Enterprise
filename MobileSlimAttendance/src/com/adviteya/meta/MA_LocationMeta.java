package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:07")
/** */
public final class MA_LocationMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Location> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location>(this, "active", "active");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Location, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Address>, com.adviteya.model.MA_Address> addressRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Location, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Address>, com.adviteya.model.MA_Address>(this, "addressRef", "addressRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Address.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Location, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Location, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, com.google.appengine.api.datastore.GeoPt> geoPoints = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, com.google.appengine.api.datastore.GeoPt>(this, "geoPoints", "geoPoints", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location> locationName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location>(this, "locationName", "locationName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location> timeZone = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location>(this, "timeZone", "timeZone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Location>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Location, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_LocationMeta slim3_singleton = new MA_LocationMeta();

    /**
     * @return the singleton
     */
    public static MA_LocationMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_LocationMeta() {
        super("MA_Location", com.adviteya.model.MA_Location.class);
    }

    @Override
    public com.adviteya.model.MA_Location entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Location model = new com.adviteya.model.MA_Location();
        model.setActive((java.lang.String) entity.getProperty("active"));
        if (model.getAddressRef() == null) {
            throw new NullPointerException("The property(addressRef) is null.");
        }
        model.getAddressRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("addressRef"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setGeoPoints((com.google.appengine.api.datastore.GeoPt) entity.getProperty("geoPoints"));
        model.setLocationName((java.lang.String) entity.getProperty("locationName"));
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
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        if (m.getAddressRef() == null) {
            throw new NullPointerException("The property(addressRef) must not be null.");
        }
        entity.setProperty("addressRef", m.getAddressRef().getKey());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("geoPoints", m.getGeoPoints());
        entity.setProperty("locationName", m.getLocationName());
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
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        if (m.getAddressRef() == null) {
            throw new NullPointerException("The property(addressRef) must not be null.");
        }
        m.getAddressRef().assignKeyIfNecessary(ds);
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
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
        com.adviteya.model.MA_Location m = (com.adviteya.model.MA_Location) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getAddressRef() != null && m.getAddressRef().getKey() != null){
            writer.setNextPropertyName("addressRef");
            encoder0.encode(writer, m.getAddressRef(), maxDepth, currentDepth);
        }
        if(m.getAssignments() != null){
            writer.setNextPropertyName("assignments");
            // com.adviteya.model.MA_Assignment is not supported.
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getGeoPoints() != null){
            writer.setNextPropertyName("geoPoints");
            encoder0.encode(writer, m.getGeoPoints());
        }
        if(m.getLocationName() != null){
            writer.setNextPropertyName("locationName");
            encoder0.encode(writer, m.getLocationName());
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
    protected com.adviteya.model.MA_Location jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Location m = new com.adviteya.model.MA_Location();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("addressRef");
        decoder0.decode(reader, m.getAddressRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("assignments");
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("geoPoints");
        m.setGeoPoints(decoder0.decode(reader, m.getGeoPoints()));
        reader = rootReader.newObjectReader("locationName");
        m.setLocationName(decoder0.decode(reader, m.getLocationName()));
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