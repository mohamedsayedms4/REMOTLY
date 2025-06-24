package model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enum representing school subjects in the Egyptian education system.
 * Each subject is defined with its Arabic name and the academic years it is available in.
 * Subjects span across primary, preparatory, and secondary stages.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 * Version: 1.0
 */
public enum Subject {

    // Subjects with corresponding academic years
    ARABIC("اللغة العربية",
            AcademicYear.GRADE_1_PRIMARY, AcademicYear.GRADE_2_PRIMARY, AcademicYear.GRADE_3_PRIMARY,
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY, AcademicYear.GRADE_3_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY, AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    ENGLISH("اللغة الإنجليزية",
            AcademicYear.GRADE_1_PRIMARY, AcademicYear.GRADE_2_PRIMARY, AcademicYear.GRADE_3_PRIMARY,
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY, AcademicYear.GRADE_3_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY, AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    MATHEMATICS("الرياضيات",
            AcademicYear.GRADE_1_PRIMARY, AcademicYear.GRADE_2_PRIMARY, AcademicYear.GRADE_3_PRIMARY,
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY, AcademicYear.GRADE_3_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY, AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    SCIENCE("العلوم",
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY),

    SOCIAL_STUDIES("الدراسات الاجتماعية",
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY),

    RELIGION("التربية الدينية",
            AcademicYear.GRADE_1_PRIMARY, AcademicYear.GRADE_2_PRIMARY, AcademicYear.GRADE_3_PRIMARY,
            AcademicYear.GRADE_4_PRIMARY, AcademicYear.GRADE_5_PRIMARY, AcademicYear.GRADE_6_PRIMARY,
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY, AcademicYear.GRADE_3_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY, AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    PHYSICS("الفيزياء",
            AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    CHEMISTRY("الكيمياء",
            AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    BIOLOGY("الأحياء",
            AcademicYear.GRADE_2_SECONDARY, AcademicYear.GRADE_3_SECONDARY),

    PHILOSOPHY("الفلسفة",
            AcademicYear.GRADE_3_SECONDARY),

    GEOGRAPHY("الجغرافيا",
            AcademicYear.GRADE_1_SECONDARY),

    HISTORY("التاريخ",
            AcademicYear.GRADE_1_SECONDARY),

    COMPUTER("الحاسب الآلي",
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY, AcademicYear.GRADE_3_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY),

    ART("التربية الفنية",
            AcademicYear.GRADE_1_PRIMARY, AcademicYear.GRADE_2_PRIMARY, AcademicYear.GRADE_3_PRIMARY,
            AcademicYear.GRADE_4_PRIMARY),

    FRENCH("اللغة الفرنسية",
            AcademicYear.GRADE_1_PREPARATORY, AcademicYear.GRADE_2_PREPARATORY,
            AcademicYear.GRADE_1_SECONDARY, AcademicYear.GRADE_2_SECONDARY),

    ECONOMICS("الاقتصاد",
            AcademicYear.GRADE_3_SECONDARY),

    MATH_PURE("الرياضيات البحتة",
            AcademicYear.GRADE_3_SECONDARY),

    MATH_APPLIED("الرياضيات التطبيقية",
            AcademicYear.GRADE_3_SECONDARY);

    /**
     * Arabic name of the subject.
     */
    private final String arabicName;

    /**
     * Set of academic years in which this subject is available.
     */
    private final Set<AcademicYear> academicYears;

    /**
     * Constructor to initialize the subject with its Arabic name and available academic years.
     *
     * @param arabicName Arabic name of the subject
     * @param years      Varargs list of academic years the subject is available in
     */
    Subject(String arabicName, AcademicYear... years) {
        this.arabicName = arabicName;
        this.academicYears = EnumSet.of(years[0], years);
    }

    /**
     * Gets the Arabic name of the subject.
     *
     * @return Arabic name
     */
    public String getArabicName() {
        return arabicName;
    }

    /**
     * Returns the English name (enum name) of the subject.
     *
     * @return the English name (e.g., "ARABIC", "ENGLISH", etc.)
     */
    public String getEnglishName() {
        return name();
    }


    /**
     * Gets the set of academic years in which this subject is available.
     *
     * @return Set of academic years
     */
    public Set<AcademicYear> getAcademicYears() {
        return academicYears;
    }

    /**
     * Checks if the subject is available in a specific academic year.
     *
     * @param year the academic year to check
     * @return true if available, false otherwise
     */
    public boolean isAvailableIn(AcademicYear year) {
        return academicYears.contains(year);
    }

    /**
     * Returns a list of subjects available for a specific academic year.
     *
     * @param year the academic year to filter by
     * @return list of matching subjects
     */
    public static List<Subject> getSubjectsByAcademicYear(AcademicYear year) {
        return List.of(Subject.values()).stream()
                .filter(subject -> subject.isAvailableIn(year))
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of subjects available for a given educational stage (PRIMARY, etc.).
     *
     * @param stage the educational stage
     * @return list of subjects for that stage
     */
    public static List<Subject> getSubjectsByStage(Stage stage) {
        List<AcademicYear> yearsInStage = new ArrayList<>();

        for (AcademicYear year : AcademicYear.values()) {
            if (year.getStage() == stage) {
                yearsInStage.add(year);
            }
        }

        return List.of(Subject.values()).stream()
                .filter(subject -> subject.getAcademicYears().stream().anyMatch(yearsInStage::contains))
                .collect(Collectors.toList());
    }

    /**
     * Overrides toString to include both enum name and Arabic name.
     *
     * @return string representation of the subject
     */
    @Override
    public String toString() {
        return name() + " (" + arabicName + ")";
    }
}
