package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:08")
/** */
public final class MA_InvoiceMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Invoice> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> adjustment = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "adjustment", "adjustment", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date> amountPayDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date>(this, "amountPayDate", "amountPayDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> amountPayable = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "amountPayable", "amountPayable", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> amountToBePaidAfterDueDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "amountToBePaidAfterDueDate", "amountToBePaidAfterDueDate", double.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Contract>, com.adviteya.model.MA_Contract> contractRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Contract>, com.adviteya.model.MA_Contract>(this, "contractRef", "contractRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Contract.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> currentMonthCharges = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "currentMonthCharges", "currentMonthCharges", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date> latePaymentAcceptableDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date>(this, "latePaymentAcceptableDate", "latePaymentAcceptableDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> latePaymentAmount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "latePaymentAmount", "latePaymentAmount", double.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Invoice, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> payementReceived = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "payementReceived", "payementReceived", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double> previousBalance = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Double>(this, "previousBalance", "previousBalance", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Invoice> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Invoice>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Invoice> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Invoice>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Invoice, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_InvoiceMeta slim3_singleton = new MA_InvoiceMeta();

    /**
     * @return the singleton
     */
    public static MA_InvoiceMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_InvoiceMeta() {
        super("MA_Invoice", com.adviteya.model.MA_Invoice.class);
    }

    @Override
    public com.adviteya.model.MA_Invoice entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Invoice model = new com.adviteya.model.MA_Invoice();
        model.setAdjustment(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("adjustment")));
        model.setAmountPayDate((java.util.Date) entity.getProperty("amountPayDate"));
        model.setAmountPayable(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("amountPayable")));
        model.setAmountToBePaidAfterDueDate(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("amountToBePaidAfterDueDate")));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        if (model.getContractRef() == null) {
            throw new NullPointerException("The property(contractRef) is null.");
        }
        model.getContractRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("contractRef"));
        model.setCurrentMonthCharges(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("currentMonthCharges")));
        model.setLatePaymentAcceptableDate((java.util.Date) entity.getProperty("latePaymentAcceptableDate"));
        model.setLatePaymentAmount(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("latePaymentAmount")));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setPayementReceived(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("payementReceived")));
        model.setPreviousBalance(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("previousBalance")));
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
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("adjustment", m.getAdjustment());
        entity.setProperty("amountPayDate", m.getAmountPayDate());
        entity.setProperty("amountPayable", m.getAmountPayable());
        entity.setProperty("amountToBePaidAfterDueDate", m.getAmountToBePaidAfterDueDate());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        if (m.getContractRef() == null) {
            throw new NullPointerException("The property(contractRef) must not be null.");
        }
        entity.setProperty("contractRef", m.getContractRef().getKey());
        entity.setProperty("currentMonthCharges", m.getCurrentMonthCharges());
        entity.setProperty("latePaymentAcceptableDate", m.getLatePaymentAcceptableDate());
        entity.setProperty("latePaymentAmount", m.getLatePaymentAmount());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("payementReceived", m.getPayementReceived());
        entity.setProperty("previousBalance", m.getPreviousBalance());
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
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getContractRef() == null) {
            throw new NullPointerException("The property(contractRef) must not be null.");
        }
        m.getContractRef().assignKeyIfNecessary(ds);
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
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
        com.adviteya.model.MA_Invoice m = (com.adviteya.model.MA_Invoice) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("adjustment");
        encoder0.encode(writer, m.getAdjustment());
        if(m.getAmountPayDate() != null){
            writer.setNextPropertyName("amountPayDate");
            encoder0.encode(writer, m.getAmountPayDate());
        }
        writer.setNextPropertyName("amountPayable");
        encoder0.encode(writer, m.getAmountPayable());
        writer.setNextPropertyName("amountToBePaidAfterDueDate");
        encoder0.encode(writer, m.getAmountToBePaidAfterDueDate());
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getContractRef() != null && m.getContractRef().getKey() != null){
            writer.setNextPropertyName("contractRef");
            encoder0.encode(writer, m.getContractRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("currentMonthCharges");
        encoder0.encode(writer, m.getCurrentMonthCharges());
        if(m.getLatePaymentAcceptableDate() != null){
            writer.setNextPropertyName("latePaymentAcceptableDate");
            encoder0.encode(writer, m.getLatePaymentAcceptableDate());
        }
        writer.setNextPropertyName("latePaymentAmount");
        encoder0.encode(writer, m.getLatePaymentAmount());
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("payementReceived");
        encoder0.encode(writer, m.getPayementReceived());
        writer.setNextPropertyName("previousBalance");
        encoder0.encode(writer, m.getPreviousBalance());
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
    protected com.adviteya.model.MA_Invoice jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Invoice m = new com.adviteya.model.MA_Invoice();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("adjustment");
        m.setAdjustment(decoder0.decode(reader, m.getAdjustment()));
        reader = rootReader.newObjectReader("amountPayDate");
        m.setAmountPayDate(decoder0.decode(reader, m.getAmountPayDate()));
        reader = rootReader.newObjectReader("amountPayable");
        m.setAmountPayable(decoder0.decode(reader, m.getAmountPayable()));
        reader = rootReader.newObjectReader("amountToBePaidAfterDueDate");
        m.setAmountToBePaidAfterDueDate(decoder0.decode(reader, m.getAmountToBePaidAfterDueDate()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("contractRef");
        decoder0.decode(reader, m.getContractRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("currentMonthCharges");
        m.setCurrentMonthCharges(decoder0.decode(reader, m.getCurrentMonthCharges()));
        reader = rootReader.newObjectReader("latePaymentAcceptableDate");
        m.setLatePaymentAcceptableDate(decoder0.decode(reader, m.getLatePaymentAcceptableDate()));
        reader = rootReader.newObjectReader("latePaymentAmount");
        m.setLatePaymentAmount(decoder0.decode(reader, m.getLatePaymentAmount()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("payementReceived");
        m.setPayementReceived(decoder0.decode(reader, m.getPayementReceived()));
        reader = rootReader.newObjectReader("previousBalance");
        m.setPreviousBalance(decoder0.decode(reader, m.getPreviousBalance()));
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