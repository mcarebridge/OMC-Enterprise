package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:07")
/** */
public final class MA_PackageMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Package> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Boolean> approved = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Boolean>(this, "approved", "approved", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Double> discount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Double>(this, "discount", "discount", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package> discountType = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package>(this, "discountType", "discountType");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date> endDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date>(this, "endDate", "endDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Integer> maxEmpCount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Integer>(this, "maxEmpCount", "maxEmpCount", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Integer> minEmpCount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Integer>(this, "minEmpCount", "minEmpCount", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package> packageName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package>(this, "packageName", "packageName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Double> standardRate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Double>(this, "standardRate", "standardRate", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Package>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Package, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_PackageMeta slim3_singleton = new MA_PackageMeta();

    /**
     * @return the singleton
     */
    public static MA_PackageMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_PackageMeta() {
        super("MA_Package", com.adviteya.model.MA_Package.class);
    }

    @Override
    public com.adviteya.model.MA_Package entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Package model = new com.adviteya.model.MA_Package();
        model.setApproved(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("approved")));
        model.setDiscount(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("discount")));
        model.setDiscountType((java.lang.String) entity.getProperty("discountType"));
        model.setEndDate((java.util.Date) entity.getProperty("endDate"));
        model.setMaxEmpCount(longToPrimitiveInt((java.lang.Long) entity.getProperty("maxEmpCount")));
        model.setMinEmpCount(longToPrimitiveInt((java.lang.Long) entity.getProperty("minEmpCount")));
        model.setPackageName((java.lang.String) entity.getProperty("packageName"));
        model.setStandardRate(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("standardRate")));
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
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
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("approved", m.isApproved());
        entity.setProperty("discount", m.getDiscount());
        entity.setProperty("discountType", m.getDiscountType());
        entity.setProperty("endDate", m.getEndDate());
        entity.setProperty("maxEmpCount", m.getMaxEmpCount());
        entity.setProperty("minEmpCount", m.getMinEmpCount());
        entity.setProperty("packageName", m.getPackageName());
        entity.setProperty("standardRate", m.getStandardRate());
        entity.setProperty("startDate", m.getStartDate());
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
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
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
        com.adviteya.model.MA_Package m = (com.adviteya.model.MA_Package) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("approved");
        encoder0.encode(writer, m.isApproved());
        writer.setNextPropertyName("discount");
        encoder0.encode(writer, m.getDiscount());
        if(m.getDiscountType() != null){
            writer.setNextPropertyName("discountType");
            encoder0.encode(writer, m.getDiscountType());
        }
        if(m.getEndDate() != null){
            writer.setNextPropertyName("endDate");
            encoder0.encode(writer, m.getEndDate());
        }
        writer.setNextPropertyName("maxEmpCount");
        encoder0.encode(writer, m.getMaxEmpCount());
        writer.setNextPropertyName("minEmpCount");
        encoder0.encode(writer, m.getMinEmpCount());
        if(m.getPackageName() != null){
            writer.setNextPropertyName("packageName");
            encoder0.encode(writer, m.getPackageName());
        }
        writer.setNextPropertyName("standardRate");
        encoder0.encode(writer, m.getStandardRate());
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
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
    protected com.adviteya.model.MA_Package jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Package m = new com.adviteya.model.MA_Package();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("approved");
        m.setApproved(decoder0.decode(reader, m.isApproved()));
        reader = rootReader.newObjectReader("discount");
        m.setDiscount(decoder0.decode(reader, m.getDiscount()));
        reader = rootReader.newObjectReader("discountType");
        m.setDiscountType(decoder0.decode(reader, m.getDiscountType()));
        reader = rootReader.newObjectReader("endDate");
        m.setEndDate(decoder0.decode(reader, m.getEndDate()));
        reader = rootReader.newObjectReader("maxEmpCount");
        m.setMaxEmpCount(decoder0.decode(reader, m.getMaxEmpCount()));
        reader = rootReader.newObjectReader("minEmpCount");
        m.setMinEmpCount(decoder0.decode(reader, m.getMinEmpCount()));
        reader = rootReader.newObjectReader("packageName");
        m.setPackageName(decoder0.decode(reader, m.getPackageName()));
        reader = rootReader.newObjectReader("standardRate");
        m.setStandardRate(decoder0.decode(reader, m.getStandardRate()));
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
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