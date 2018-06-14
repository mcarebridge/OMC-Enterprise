package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:07")
/** */
public final class MA_ReceivablesMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Receivables> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date> amountReceivedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date>(this, "amountReceivedDate", "amountReceivedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double> amountRecievedAmount = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double>(this, "amountRecievedAmount", "amountRecievedAmount", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double> bankCharges = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double>(this, "bankCharges", "bankCharges", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> clearingBank = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "clearingBank", "clearingBank");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double> exchangeRate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Double>(this, "exchangeRate", "exchangeRate", double.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Receivables, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Invoice>, com.adviteya.model.MA_Invoice> invoiceRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Receivables, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Invoice>, com.adviteya.model.MA_Invoice>(this, "invoiceRef", "invoiceRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Invoice.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> issuingBank = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "issuingBank", "issuingBank");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> receiverCurrency = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "receiverCurrency", "receiverCurrency");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> senderCurrency = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "senderCurrency", "senderCurrency");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Receivables>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Receivables, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_ReceivablesMeta slim3_singleton = new MA_ReceivablesMeta();

    /**
     * @return the singleton
     */
    public static MA_ReceivablesMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_ReceivablesMeta() {
        super("MA_Receivables", com.adviteya.model.MA_Receivables.class);
    }

    @Override
    public com.adviteya.model.MA_Receivables entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Receivables model = new com.adviteya.model.MA_Receivables();
        model.setAmountReceivedDate((java.util.Date) entity.getProperty("amountReceivedDate"));
        model.setAmountRecievedAmount(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("amountRecievedAmount")));
        model.setBankCharges(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("bankCharges")));
        model.setClearingBank((java.lang.String) entity.getProperty("clearingBank"));
        model.setExchangeRate(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("exchangeRate")));
        if (model.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) is null.");
        }
        model.getInvoiceRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("invoiceRef"));
        model.setIssuingBank((java.lang.String) entity.getProperty("issuingBank"));
        model.setReceiverCurrency((java.lang.String) entity.getProperty("receiverCurrency"));
        model.setSenderCurrency((java.lang.String) entity.getProperty("senderCurrency"));
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
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("amountReceivedDate", m.getAmountReceivedDate());
        entity.setProperty("amountRecievedAmount", m.getAmountRecievedAmount());
        entity.setProperty("bankCharges", m.getBankCharges());
        entity.setProperty("clearingBank", m.getClearingBank());
        entity.setProperty("exchangeRate", m.getExchangeRate());
        if (m.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) must not be null.");
        }
        entity.setProperty("invoiceRef", m.getInvoiceRef().getKey());
        entity.setProperty("issuingBank", m.getIssuingBank());
        entity.setProperty("receiverCurrency", m.getReceiverCurrency());
        entity.setProperty("senderCurrency", m.getSenderCurrency());
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
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        if (m.getInvoiceRef() == null) {
            throw new NullPointerException("The property(invoiceRef) must not be null.");
        }
        m.getInvoiceRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
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
        com.adviteya.model.MA_Receivables m = (com.adviteya.model.MA_Receivables) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAmountReceivedDate() != null){
            writer.setNextPropertyName("amountReceivedDate");
            encoder0.encode(writer, m.getAmountReceivedDate());
        }
        writer.setNextPropertyName("amountRecievedAmount");
        encoder0.encode(writer, m.getAmountRecievedAmount());
        writer.setNextPropertyName("bankCharges");
        encoder0.encode(writer, m.getBankCharges());
        if(m.getClearingBank() != null){
            writer.setNextPropertyName("clearingBank");
            encoder0.encode(writer, m.getClearingBank());
        }
        writer.setNextPropertyName("exchangeRate");
        encoder0.encode(writer, m.getExchangeRate());
        if(m.getInvoiceRef() != null && m.getInvoiceRef().getKey() != null){
            writer.setNextPropertyName("invoiceRef");
            encoder0.encode(writer, m.getInvoiceRef(), maxDepth, currentDepth);
        }
        if(m.getIssuingBank() != null){
            writer.setNextPropertyName("issuingBank");
            encoder0.encode(writer, m.getIssuingBank());
        }
        if(m.getReceiverCurrency() != null){
            writer.setNextPropertyName("receiverCurrency");
            encoder0.encode(writer, m.getReceiverCurrency());
        }
        if(m.getSenderCurrency() != null){
            writer.setNextPropertyName("senderCurrency");
            encoder0.encode(writer, m.getSenderCurrency());
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
    protected com.adviteya.model.MA_Receivables jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Receivables m = new com.adviteya.model.MA_Receivables();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("amountReceivedDate");
        m.setAmountReceivedDate(decoder0.decode(reader, m.getAmountReceivedDate()));
        reader = rootReader.newObjectReader("amountRecievedAmount");
        m.setAmountRecievedAmount(decoder0.decode(reader, m.getAmountRecievedAmount()));
        reader = rootReader.newObjectReader("bankCharges");
        m.setBankCharges(decoder0.decode(reader, m.getBankCharges()));
        reader = rootReader.newObjectReader("clearingBank");
        m.setClearingBank(decoder0.decode(reader, m.getClearingBank()));
        reader = rootReader.newObjectReader("exchangeRate");
        m.setExchangeRate(decoder0.decode(reader, m.getExchangeRate()));
        reader = rootReader.newObjectReader("invoiceRef");
        decoder0.decode(reader, m.getInvoiceRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("issuingBank");
        m.setIssuingBank(decoder0.decode(reader, m.getIssuingBank()));
        reader = rootReader.newObjectReader("receiverCurrency");
        m.setReceiverCurrency(decoder0.decode(reader, m.getReceiverCurrency()));
        reader = rootReader.newObjectReader("senderCurrency");
        m.setSenderCurrency(decoder0.decode(reader, m.getSenderCurrency()));
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