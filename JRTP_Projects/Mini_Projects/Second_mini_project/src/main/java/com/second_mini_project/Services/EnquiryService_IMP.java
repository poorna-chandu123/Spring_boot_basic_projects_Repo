package com.second_mini_project.Services;

import com.second_mini_project.DTO.Add_and_Update_Form;
import com.second_mini_project.DTO.DashboardPerformance;
import com.second_mini_project.DTO.Dashboard_dynamic_serch;
import com.second_mini_project.Entity.StudentEnqEntity;
import com.second_mini_project.Entity.UserDtlsEntity;
import com.second_mini_project.Repo.CourseRepo;
import com.second_mini_project.Repo.EnqStatusRepo;
import com.second_mini_project.Repo.StudentEnqRepo;
import com.second_mini_project.Repo.UserDtlsRepo;
import com.second_mini_project.Utils.Dashboard_dynamic_serch_Util;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnquiryService_IMP implements EnquiryService_inter {

    @Autowired
    private EnqStatusRepo enqStatusRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserDtlsRepo userDtlsRepo;

    @Autowired
    private StudentEnqRepo studentEnqRepo;

    @Override
    public DashboardPerformance getEnquiriesByUserId(HttpSession session) {

        // 1️⃣ Get logged-in user ID from session
        Integer userId = (Integer) session.getAttribute("userID"); // key should match with the one used during login

        if (userId == null) {
            throw  new RuntimeException ("User not logged in");
        }

        DashboardPerformance performance = new DashboardPerformance();
/*       // studentEnqRepo lo below methods ni create chesi kuda cheyachhu direct count mentod use chesthe
         // simple ga avuthundi but nenu JAVA 8 streams use chesi cheyadam try chesanu

        Integer totalEnquiries = studentEnqRepo.countByUserDtlsEntity_UserId(userId);
        Integer enrolledEnquiries = studentEnqRepo.countByUserDtlsEntity_UserIdAndEnqStatus(userId, "ENROLLED");
        Integer lostEnquiries = studentEnqRepo.countByUserDtlsEntity_UserIdAndEnqStatus(userId, "LOST");
        performance.setTotalEnquiries(totalEnquiries);
        performance.setEnrolledEnquiries(enrolledEnquiries);
        performance.setLostEnquiries(lostEnquiries);

        */
        List<StudentEnqEntity> allEnquiries = studentEnqRepo.findByUserDtlsEntity_UserId(userId);

        long totalEnquiries = allEnquiries.size();

        // count enrolled and lost using streams
        long enrolledEnquiries = allEnquiries.stream()
                .filter(enquiry -> "ENROLLED".equals(enquiry.getStudentEnqStatus()))
                .count();

        long lostEnquiries = allEnquiries.stream()
                .filter(enquiry -> "LOST".equals(enquiry.getStudentEnqStatus()))
                .count();
        performance.setTotalEnquiries((int) totalEnquiries);
        performance.setEnrolledEnquiries((int) enrolledEnquiries);
        performance.setLostEnquiries((int) lostEnquiries);

        return performance;

    }

    @Override
    public List<String> getEnquiryStatusDropDown() {
        return enqStatusRepo.getAllEnqStatusNames();
    }

    @Override
    public List<String> getCourseNamesDropDown() {
        return courseRepo.getAllCourseNames();
    }

    @Override
    public boolean addNewStudentEnquiry(Add_and_Update_Form form, HttpSession session) {

        // 1️⃣ Get logged-in user ID from session
        Integer userId = (Integer) session.getAttribute("userID"); // key should match with the one used during login

        if (userId == null) {
            throw  new RuntimeException ("User not logged in");
        }

        // 2️⃣ copy properties from form DTO to entity
        StudentEnqEntity entity = new StudentEnqEntity();
        BeanUtils.copyProperties(form, entity);

        // 3️⃣ Set userId in the enquiry entity
        UserDtlsEntity present = userDtlsRepo.findById((userId)).get();

        entity.setUserDtlsEntity(present);
        // set created time as system time
        entity.setStudentCreatedDate(new java.util.Date());

        // 4️⃣ Save to DB
        studentEnqRepo.save(entity);

        return true;

    }
    @Override
    public boolean updateStudentEnquiry(Add_and_Update_Form form, HttpSession session) {

        // 1️⃣ Get logged-in user ID
        Integer userId = (Integer) session.getAttribute("userID");

        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        // 2️⃣ Fetch existing enquiry
        StudentEnqEntity existing = studentEnqRepo.findById(form.getStudentId())
                .orElseThrow(() -> new RuntimeException("Enquiry not found"));

        // 3️⃣ Ensure this enquiry belongs to the logged-in user
        if (!existing.getUserDtlsEntity().getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized: This enquiry does not belong to the logged-in user");
        }

        // 4️⃣ Update only modifiable fields
        existing.setStudentName(form.getStudentName());
        existing.setStudentPhno(form.getStudentPhno());
        existing.setStudentClassMode(form.getStudentClassMode());
        existing.setStudentCourse(form.getStudentCourse());
        existing.setStudentEnqStatus(form.getStudentEnqStatus());

        // updated date
        existing.setStudentUpdatedDate(new Date());

        // 5️⃣ Save changes
        studentEnqRepo.save(existing);

        return true;
    }

    @Override
    public List<StudentEnqEntity> searchStudentEnquiry(Dashboard_dynamic_serch form, HttpSession session) {

        if (session.getAttribute("userID")==null){
            throw new RuntimeException("User not logged in");
        }

       return studentEnqRepo.findAll(Dashboard_dynamic_serch_Util.getSearchQuery(form));


    }




}
