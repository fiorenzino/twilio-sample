package org.twiliofaces.test.sample.model;

import java.io.Serializable;

public class Caller implements Serializable
{
   private static final long serialVersionUID = 1L;
   private String from;
   private String recordingUrl;

   public Caller()
   {
   }

   public Caller(String from)
   {
      this.from = from;
   }

   public String getFrom()
   {
      return from;
   }

   public void setFrom(String from)
   {
      this.from = from;
   }

   public String getRecordingUrl()
   {
      return recordingUrl;
   }

   public void setRecordingUrl(String recordingUrl)
   {
      this.recordingUrl = recordingUrl;
   }

}
