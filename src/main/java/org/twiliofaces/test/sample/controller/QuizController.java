package org.twiliofaces.test.sample.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.notification.Digits;
import org.twiliofaces.annotations.notification.From;
import org.twiliofaces.annotations.notification.RecordingUrl;
import org.twiliofaces.annotations.scope.TwilioScope;

@TwilioScope
@Named
public class QuizController implements Serializable
{

   private static final long serialVersionUID = 1L;

   Logger logger = Logger.getLogger(QuizController.class.getName());

   @Inject
   @CallSid
   String callSid;

   @Inject
   @From
   String from;

   @Inject
   @RecordingUrl
   String recordingUrl;

   @Inject
   @Digits
   String digits;

   int count = 0;

   public QuizController()
   {
      logger.info("QuizController: " + new Date());
   }

   public void first()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("from number:" + from);
   }

   public void second()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("recording url: " + recordingUrl);
   }

   public void third()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("digits: " + digits);
   }

   public String getIntro()
   {
      return "What's your name?";

   }

   public String getHangoutMessage()
   {
      return "Hey, you don't want play with me! Bye bye";
   }

   public String getQuestion()
   {
      return "What's the name of Italy capital? Click 1 for Rome, click 2 for Milan, click 3 for Venice.";

   }

   public String getResult()
   {
      if (digits != null && digits.equals("1"))
      {
         return "Awesome! your answer is correct";
      }
      return "Nooo! You must to go in Italy!! Rome is the Italy's capital!";

   }

}