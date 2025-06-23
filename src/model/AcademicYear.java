package model;

/**
 * Enum representing all academic years in the Egyptian school system.
 * It includes three educational stages:
 * - Primary: Grades 1–6
 * - Preparatory: Grades 1–3
 * - Secondary: Grades 1–3
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 * Version: 2.0
 */
public enum AcademicYear {

    // Primary Stage
    GRADE_1_PRIMARY("Grade 1 - Primary", Stage.PRIMARY),
    GRADE_2_PRIMARY("Grade 2 - Primary", Stage.PRIMARY),
    GRADE_3_PRIMARY("Grade 3 - Primary", Stage.PRIMARY),
    GRADE_4_PRIMARY("Grade 4 - Primary", Stage.PRIMARY),
    GRADE_5_PRIMARY("Grade 5 - Primary", Stage.PRIMARY),
    GRADE_6_PRIMARY("Grade 6 - Primary", Stage.PRIMARY),

    // Preparatory Stage
    GRADE_1_PREPARATORY("Grade 1 - Preparatory", Stage.PREPARATORY),
    GRADE_2_PREPARATORY("Grade 2 - Preparatory", Stage.PREPARATORY),
    GRADE_3_PREPARATORY("Grade 3 - Preparatory", Stage.PREPARATORY),

    // Secondary Stage
    GRADE_1_SECONDARY("Grade 1 - Secondary", Stage.SECONDARY),
    GRADE_2_SECONDARY("Grade 2 - Secondary", Stage.SECONDARY),
    GRADE_3_SECONDARY("Grade 3 - Secondary", Stage.SECONDARY);

    /**
     * Human-readable name of the academic year.
     */
    private final String displayName;

    /**
     * The educational stage this academic year belongs to.
     */
    private final Stage stage;

    /**
     * Constructor for the AcademicYear enum.
     *
     * @param displayName the display name for the academic year
     * @param stage       the stage to which the year belongs
     */
    AcademicYear(String displayName, Stage stage) {
        this.displayName = displayName;
        this.stage = stage;
    }

    /**
     * Gets the display name of the academic year.
     *
     * @return display name (e.g., "Grade 1 - Primary")
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the educational stage of the academic year.
     *
     * @return the educational stage (e.g., PRIMARY, PREPARATORY, SECONDARY)
     */
    public Stage getStage() {
        return stage;
    }
}
