package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:08")
/** */
public final class MA_EmployeeMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Employee> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "active", "active");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> city = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "city", "city");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> companyEmpId = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "companyEmpId", "companyEmpId");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> dayOfWeeklyOff = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "dayOfWeeklyOff", "dayOfWeeklyOff");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> emailId = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "emailId", "emailId");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> empPwd = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "empPwd", "empPwd");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> employeeType = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "employeeType", "employeeType");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> firstName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> gender = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "gender", "gender");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> imeiCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "imeiCode", "imeiCode");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date> inActiveDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date>(this, "inActiveDate", "inActiveDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> isSuperwiser = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "isSuperwiser", "isSuperwiser");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> lastName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Integer> minWorkingHrsPerDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Integer>(this, "minWorkingHrsPerDay", "minWorkingHrsPerDay", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Integer> numOfWorkingDays = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Integer>(this, "numOfWorkingDays", "numOfWorkingDays", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> salutation = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "salutation", "salutation");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_TemplateSkill>, com.adviteya.model.MA_TemplateSkill> skillRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Employee, org.slim3.datastore.ModelRef<com.adviteya.model.MA_TemplateSkill>, com.adviteya.model.MA_TemplateSkill>(this, "skillRef", "skillRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_TemplateSkill.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Boolean> weeklyOffFlexible = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Boolean>(this, "weeklyOffFlexible", "weeklyOffFlexible", boolean.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Employee>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Employee, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_EmployeeMeta slim3_singleton = new MA_EmployeeMeta();

    /**
     * @return the singleton
     */
    public static MA_EmployeeMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_EmployeeMeta() {
        super("MA_Employee", com.adviteya.model.MA_Employee.class);
    }

    @Override
    public com.adviteya.model.MA_Employee entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Employee model = new com.adviteya.model.MA_Employee();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setCity((java.lang.String) entity.getProperty("city"));
        model.setCompanyEmpId((java.lang.String) entity.getProperty("companyEmpId"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setDayOfWeeklyOff((java.lang.String) entity.getProperty("dayOfWeeklyOff"));
        model.setEmailId((java.lang.String) entity.getProperty("emailId"));
        model.setEmpPwd((java.lang.String) entity.getProperty("empPwd"));
        model.setEmployeeType((java.lang.String) entity.getProperty("employeeType"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setGender((java.lang.String) entity.getProperty("gender"));
        model.setImeiCode((java.lang.String) entity.getProperty("imeiCode"));
        model.setInActiveDate((java.util.Date) entity.getProperty("inActiveDate"));
        model.setIsSuperwiser((java.lang.String) entity.getProperty("isSuperwiser"));
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setMinWorkingHrsPerDay(longToInteger((java.lang.Long) entity.getProperty("minWorkingHrsPerDay")));
        model.setNumOfWorkingDays(longToInteger((java.lang.Long) entity.getProperty("numOfWorkingDays")));
        model.setSalutation((java.lang.String) entity.getProperty("salutation"));
        if (model.getSkillRef() == null) {
            throw new NullPointerException("The property(skillRef) is null.");
        }
        model.getSkillRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("skillRef"));
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
        model.setWeeklyOffFlexible(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("weeklyOffFlexible")));
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
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("city", m.getCity());
        entity.setProperty("companyEmpId", m.getCompanyEmpId());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("dayOfWeeklyOff", m.getDayOfWeeklyOff());
        entity.setProperty("emailId", m.getEmailId());
        entity.setProperty("empPwd", m.getEmpPwd());
        entity.setProperty("employeeType", m.getEmployeeType());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("gender", m.getGender());
        entity.setProperty("imeiCode", m.getImeiCode());
        entity.setProperty("inActiveDate", m.getInActiveDate());
        entity.setProperty("isSuperwiser", m.getIsSuperwiser());
        entity.setProperty("lastName", m.getLastName());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("minWorkingHrsPerDay", m.getMinWorkingHrsPerDay());
        entity.setProperty("numOfWorkingDays", m.getNumOfWorkingDays());
        entity.setProperty("salutation", m.getSalutation());
        if (m.getSkillRef() == null) {
            throw new NullPointerException("The property(skillRef) must not be null.");
        }
        entity.setProperty("skillRef", m.getSkillRef().getKey());
        entity.setProperty("startDate", m.getStartDate());
        entity.setProperty("weeklyOffFlexible", m.isWeeklyOffFlexible());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 5);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
        if (m.getSkillRef() == null) {
            throw new NullPointerException("The property(skillRef) must not be null.");
        }
        m.getSkillRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
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
        com.adviteya.model.MA_Employee m = (com.adviteya.model.MA_Employee) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getAssignments() != null){
            writer.setNextPropertyName("assignments");
            // com.adviteya.model.MA_Assignment is not supported.
        }
        if(m.getCity() != null){
            writer.setNextPropertyName("city");
            encoder0.encode(writer, m.getCity());
        }
        if(m.getCompanyEmpId() != null){
            writer.setNextPropertyName("companyEmpId");
            encoder0.encode(writer, m.getCompanyEmpId());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getDayOfWeeklyOff() != null){
            writer.setNextPropertyName("dayOfWeeklyOff");
            encoder0.encode(writer, m.getDayOfWeeklyOff());
        }
        if(m.getEmailId() != null){
            writer.setNextPropertyName("emailId");
            encoder0.encode(writer, m.getEmailId());
        }
        if(m.getEmpPwd() != null){
            writer.setNextPropertyName("empPwd");
            encoder0.encode(writer, m.getEmpPwd());
        }
        if(m.getEmployeeType() != null){
            writer.setNextPropertyName("employeeType");
            encoder0.encode(writer, m.getEmployeeType());
        }
        if(m.getFirstName() != null){
            writer.setNextPropertyName("firstName");
            encoder0.encode(writer, m.getFirstName());
        }
        if(m.getGender() != null){
            writer.setNextPropertyName("gender");
            encoder0.encode(writer, m.getGender());
        }
        if(m.getImeiCode() != null){
            writer.setNextPropertyName("imeiCode");
            encoder0.encode(writer, m.getImeiCode());
        }
        if(m.getInActiveDate() != null){
            writer.setNextPropertyName("inActiveDate");
            encoder0.encode(writer, m.getInActiveDate());
        }
        if(m.getIsSuperwiser() != null){
            writer.setNextPropertyName("isSuperwiser");
            encoder0.encode(writer, m.getIsSuperwiser());
        }
        if(m.getLastName() != null){
            writer.setNextPropertyName("lastName");
            encoder0.encode(writer, m.getLastName());
        }
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        if(m.getMinWorkingHrsPerDay() != null){
            writer.setNextPropertyName("minWorkingHrsPerDay");
            encoder0.encode(writer, m.getMinWorkingHrsPerDay());
        }
        if(m.getNumOfWorkingDays() != null){
            writer.setNextPropertyName("numOfWorkingDays");
            encoder0.encode(writer, m.getNumOfWorkingDays());
        }
        if(m.getSalutation() != null){
            writer.setNextPropertyName("salutation");
            encoder0.encode(writer, m.getSalutation());
        }
        if(m.getSkillRef() != null && m.getSkillRef().getKey() != null){
            writer.setNextPropertyName("skillRef");
            encoder0.encode(writer, m.getSkillRef(), maxDepth, currentDepth);
        }
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
        }
        writer.setNextPropertyName("weeklyOffFlexible");
        encoder0.encode(writer, m.isWeeklyOffFlexible());
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
    protected com.adviteya.model.MA_Employee jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Employee m = new com.adviteya.model.MA_Employee();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("assignments");
        reader = rootReader.newObjectReader("city");
        m.setCity(decoder0.decode(reader, m.getCity()));
        reader = rootReader.newObjectReader("companyEmpId");
        m.setCompanyEmpId(decoder0.decode(reader, m.getCompanyEmpId()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("dayOfWeeklyOff");
        m.setDayOfWeeklyOff(decoder0.decode(reader, m.getDayOfWeeklyOff()));
        reader = rootReader.newObjectReader("emailId");
        m.setEmailId(decoder0.decode(reader, m.getEmailId()));
        reader = rootReader.newObjectReader("empPwd");
        m.setEmpPwd(decoder0.decode(reader, m.getEmpPwd()));
        reader = rootReader.newObjectReader("employeeType");
        m.setEmployeeType(decoder0.decode(reader, m.getEmployeeType()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("gender");
        m.setGender(decoder0.decode(reader, m.getGender()));
        reader = rootReader.newObjectReader("imeiCode");
        m.setImeiCode(decoder0.decode(reader, m.getImeiCode()));
        reader = rootReader.newObjectReader("inActiveDate");
        m.setInActiveDate(decoder0.decode(reader, m.getInActiveDate()));
        reader = rootReader.newObjectReader("isSuperwiser");
        m.setIsSuperwiser(decoder0.decode(reader, m.getIsSuperwiser()));
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("minWorkingHrsPerDay");
        m.setMinWorkingHrsPerDay(decoder0.decode(reader, m.getMinWorkingHrsPerDay()));
        reader = rootReader.newObjectReader("numOfWorkingDays");
        m.setNumOfWorkingDays(decoder0.decode(reader, m.getNumOfWorkingDays()));
        reader = rootReader.newObjectReader("salutation");
        m.setSalutation(decoder0.decode(reader, m.getSalutation()));
        reader = rootReader.newObjectReader("skillRef");
        decoder0.decode(reader, m.getSkillRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
        reader = rootReader.newObjectReader("weeklyOffFlexible");
        m.setWeeklyOffFlexible(decoder0.decode(reader, m.isWeeklyOffFlexible()));
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