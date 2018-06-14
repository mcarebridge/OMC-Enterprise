package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:08")
/** */
public final class MA_InvoiceAdjustMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_InvoiceAdjust> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.lang.Double> adjustmentAmount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.lang.Double>(this, "adjustmentAmount", "adjustmentAmount", double.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, org.slim3.datastore.ModelRef<com.adviteya.model.MA_AdjustmentType>, com.adviteya.model.MA_AdjustmentType> adjustmentTypeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, org.slim3.datastore.ModelRef<com.adviteya.model.MA_AdjustmentType>, com.adviteya.model.MA_AdjustmentType>(this, "adjustmentTypeRef", "adjustmentTypeRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_AdjustmentType.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust> approved = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust>(this, "approved", "approved");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Invoice>, com.adviteya.model.MA_Invoice> invoiceRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Invoice>, com.adviteya.model.MA_Invoice>(this, "invoiceRef", "invoiceRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Invoice.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust> reasonOfAdjustment = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust>(this, "reasonOfAdjustment", "reasonOfAdjustment");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_InvoiceAdjust>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_InvoiceAdjust, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_InvoiceAdjustMeta slim3_singleton = new MA_InvoiceAdjustMeta();

    /**
     * @return the singleton
     */
    public static MA_InvoiceAdjustMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_InvoiceAdjustMeta() {
        super("MA_InvoiceAdjust", com.adviteya.model.MA_InvoiceAdjust.class);
    }

    @Override
    public com.adviteya.model.MA_InvoiceAdjust entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_InvoiceAdjust model = new com.adviteya.model.MA_InvoiceAdjust();
        model.setAdjustmentAmount(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("adjustmentAmount")));
        if (model.getAdjustmentTypeRef() == null) {
            throw new NullPointerException("The property(adjustmentTypeRef) is null.");
        }
        model.getAdjustmentTypeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("adjustmentTypeRef"));
        model.setApproved((java.lang.String) entity.getProperty("approved"));
        if (model.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) is null.");
        }
        model.getInvoiceRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("invoiceRef"));
        model.setReasonOfAdjustment((java.lang.String) entity.getProperty("reasonOfAdjustment"));
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
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("adjustmentAmount", m.getAdjustmentAmount());
        if (m.getAdjustmentTypeRef() == null) {
            throw new NullPointerException("The property(adjustmentTypeRef) must not be null.");
        }
        entity.setProperty("adjustmentTypeRef", m.getAdjustmentTypeRef().getKey());
        entity.setProperty("approved", m.getApproved());
        if (m.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) must not be null.");
        }
        entity.setProperty("invoiceRef", m.getInvoiceRef().getKey());
        entity.setProperty("reasonOfAdjustment", m.getReasonOfAdjustment());
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
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        if (m.getAdjustmentTypeRef() == null) {
            throw new NullPointerException("The property(adjustmentTypeRef) must not be null.");
        }
        m.getAdjustmentTypeRef().assignKeyIfNecessary(ds);
        if (m.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) must not be null.");
        }
        m.getInvoiceRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
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
        com.adviteya.model.MA_InvoiceAdjust m = (com.adviteya.model.MA_InvoiceAdjust) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("adjustmentAmount");
        encoder0.encode(writer, m.getAdjustmentAmount());
        if(m.getAdjustmentTypeRef() != null && m.getAdjustmentTypeRef().getKey() != null){
            writer.setNextPropertyName("adjustmentTypeRef");
            encoder0.encode(writer, m.getAdjustmentTypeRef(), maxDepth, currentDepth);
        }
        if(m.getApproved() != null){
            writer.setNextPropertyName("approved");
            encoder0.encode(writer, m.getApproved());
        }
        if(m.getInvoiceRef() != null && m.getInvoiceRef().getKey() != null){
            writer.setNextPropertyName("invoiceRef");
            encoder0.encode(writer, m.getInvoiceRef(), maxDepth, currentDepth);
        }
        if(m.getReasonOfAdjustment() != null){
            writer.setNextPropertyName("reasonOfAdjustment");
            encoder0.encode(writer, m.getReasonOfAdjustment());
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
    protected com.adviteya.model.MA_InvoiceAdjust jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_InvoiceAdjust m = new com.adviteya.model.MA_InvoiceAdjust();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("adjustmentAmount");
        m.setAdjustmentAmount(decoder0.decode(reader, m.getAdjustmentAmount()));
        reader = rootReader.newObjectReader("adjustmentTypeRef");
        decoder0.decode(reader, m.getAdjustmentTypeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("approved");
        m.setApproved(decoder0.decode(reader, m.getApproved()));
        reader = rootReader.newObjectReader("invoiceRef");
        decoder0.decode(reader, m.getInvoiceRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("reasonOfAdjustment");
        m.setReasonOfAdjustment(decoder0.decode(reader, m.getReasonOfAdjustment()));
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