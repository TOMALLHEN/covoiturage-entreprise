
import { StyleSheet } from "react-native";
import { theme } from "../../theme";

export const loginStyles = StyleSheet.create({
  header: {
    marginBottom: theme.spacing.xxl,
    alignItems: "center",
  },

  title: {
    fontSize: theme.typography.heading,
    fontWeight: "bold",
    color: theme.colors.primary,
  },

  subtitle: {
    marginTop: theme.spacing.sm,
    fontSize: theme.typography.body,
    color: theme.colors.textSecondary,
  },

  form: {
    backgroundColor: theme.colors.surface,
    padding: theme.spacing.lg,
    borderRadius: theme.radius.lg,
  },

  heading: {
    fontSize: theme.typography.title,
    fontWeight: "bold",
    marginBottom: theme.spacing.lg,
    color: theme.colors.text,
  },

  label: {
    fontSize: theme.typography.small,
    fontWeight: "600",
    marginBottom: theme.spacing.sm,
    color: theme.colors.text,
  },

  input: {
    height: 50,
    borderWidth: 1,
    borderColor: theme.colors.border,
    borderRadius: theme.radius.md,
    paddingHorizontal: theme.spacing.md,
    marginBottom: theme.spacing.lg,
    backgroundColor: theme.colors.surface,
  },

  button: {
    height: 52,
    backgroundColor: theme.colors.primary,
    borderRadius: theme.radius.md,
    justifyContent: "center",
    alignItems: "center",
    marginTop: theme.spacing.sm,
  },

  buttonText: {
    color: theme.colors.surface,
    fontSize: theme.typography.body,
    fontWeight: "bold",
  },

  registerContainer: {
    marginTop: theme.spacing.lg,
    alignItems: "center",
  },

  registerText: {
    color: theme.colors.textSecondary,
    fontSize: theme.typography.small,
  },

  registerLink: {
    color: theme.colors.primary,
    fontWeight: "bold",
    marginTop: theme.spacing.sm,
  },
});
