package com.example.jobportal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportal.Entities.JobForm;
import com.example.jobportal.Entities.JobForm.Show;
import com.example.jobportal.Repository.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public JobForm AddJob(JobForm job) {
        if(job == null){
            return null;
        }
        return repo.save(job);
    }

    public JobForm UpdateJob(long jobid, JobForm entity) {
        Optional<JobForm> job = repo.findById(jobid);

        if(!job.isPresent()){
            return null;
        }

        job.get().setJobTitle(entity.getJobTitle());
        job.get().setDescription(entity.getDescription());
        job.get().setRequirment(entity.getRequirment());
        job.get().setSalary(entity.getSalary());
        job.get().setCategory(entity.getCategory());
        job.get().setCompanyName(entity.getCompanyName());
        job.get().setApproval(entity.getApproval());
        job.get().setLocation(entity.getLocation());
        job.get().setWorkmode(entity.getWorkmode());

        return repo.save(job.get());
        
    }

    public JobForm ChangeStatus(long jobid, String jobstatus) {
        Optional<JobForm> job = repo.findById(jobid);
        if(!job.isPresent()){
            return null;
        }
        if(jobstatus.equals("PENDING")){
            job.get().setApproval(Show.PENDING);
        }
        else if(jobstatus.equals("APPROVED")){
            job.get().setApproval(Show.APPROVED);
        }
        else{
            job.get().setApproval(Show.REJECTED);
        }

        return repo.save(job.get());
        
    }

    public List<JobForm> getAllJobs() {
        return repo.findAll();
    }

    public JobForm RemoveJob(long jobid) {
        Optional<JobForm> job = repo.findById(jobid);
        if(!job.isPresent()){
            return null;
        }
        repo.deleteById(jobid);
        return job.get();
    }
    
}


// Good catch, Aqueeb! That’s a **valid concern**, and I’m glad you're being cautious about security. Let me break it down for you:

// ---

// ## 🔍 Why Chrome Might Say “Not Secure” or “Unsafe” for `https://hirect.in`

// ### 🛡️ 1. **SSL Certificate Issues**
// - Sometimes the site’s **SSL certificate** (the thing that ensures the lock icon 🔒 in the browser) is:
//   - **Expired**
//   - **Improperly configured**
//   - Or **missing** altogether
// - When this happens, Chrome gives a warning like:  
//   > *“Your connection is not private”*  
//   or  
//   > *“This site may not be secure.”*

// ---

// ### 🐛 2. **Temporary Downtime or Misconfiguration**
// - The site might be **under maintenance** or facing temporary issues.
// - Sometimes domains redirect to third-party sites that Chrome flags as suspicious.

// ---

// ### 💥 3. **False Positive**
// - Chrome sometimes shows that for **smaller platforms** that aren't widely known or used.
// - It doesn’t always mean the site is dangerous — but you should still be cautious.

// ---

// ## ✅ What You Can Do:

// ### 🔐 Option 1: Use the App Instead
// **Hirect is primarily an app**, not a website. You can:
// - Go to **Google Play Store**
// - Search for **“Hirect – Chat based hiring”**
// - Download it from there (safe and verified)

// 👉 [Direct Play Store Link](https://play.google.com/store/apps/details?id=com.hirect&hl=en&gl=US)

// > The app is trusted by many Indian developers and startups — and it’s a legit way to apply/chat with recruiters.

// ---

// ### 🧠 Option 2: Use Alternatives
// If you're uncomfortable using Hirect, here are **other startup-friendly job platforms**:

// | Platform        | What It’s Good For                     |
// |----------------|----------------------------------------|
// | **CutShort**    | Startup jobs and internships           |
// | **AngelList / Wellfound** | Startups + remote roles            |
// | **LinkedIn Jobs** | Search by tech stack + DM recruiters |
// | **Internshala** | Internship-focused, safe site         |

// ---

// If you want, I can help you:
// - Create a job search tracker
// - Filter real opportunities for backend/Java roles on safe platforms

// Would you like that? Or want me to help explore safe startup job platforms based on your preferences?
