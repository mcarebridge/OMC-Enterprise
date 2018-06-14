package com.adviteya.model;

import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class MA_ApplicationTemplate extends AbstractEntity
{
	
	/**
     * 
     */
	private static final long serialVersionUID = 865958419678968558L;
	private String            documentName;
	private Text              documentContents;
	private String            documentVersion;
	private boolean           deprecated;
	
	public boolean isDeprecated()
	{
		return deprecated;
	}
	
	public void setDeprecated(boolean deprecated)
	{
		this.deprecated = deprecated;
	}
	
	public String getDocumentVersion()
	{
		return documentVersion;
	}
	
	public void setDocumentVersion(String documentVersion)
	{
		this.documentVersion = documentVersion;
	}
	
	public Text getDocumentContents()
	{
		return documentContents;
	}
	
	public void setDocumentContents(Text documentContents)
	{
		this.documentContents = documentContents;
	}
	
	public String getDocumentName()
	{
		return documentName;
	}
	
	public void setDocumentName(String documentName)
	{
		this.documentName = documentName;
	}
	
}
