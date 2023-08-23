package com.example.EmailNotification.EmailDetails;
// Importing required classes
import lombok.*;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmailDetails {
    // Class data members
  //  private String fromAddress;
    private String toAddress;
    private String subject;
    private String emailBody;
    private Boolean isAttachmentRequired;
    private String filePath;
}
