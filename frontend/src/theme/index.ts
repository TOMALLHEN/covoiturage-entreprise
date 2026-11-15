// regroupe les exports du thème pour faciliter les imports dans les autres fichiers.



export const theme = {
  colors: {
    primary: "#176B57",
    primaryLight: "#E5F2ED",
    background: "#F5F7F6",
    surface: "#FFFFFF",
    text: "#172B25",
    textSecondary: "#718078",
    border: "#E5EBE7",
    success: "#23865B",
    error: "#D64545",
    warning: "#E6A23C",
  },

  spacing: {
    xs: 4,
    sm: 8,
    md: 16,
    lg: 24,
    xl: 32,
    xxl: 40,
  },

  typography: {
    small: 13,
    body: 15,
    subtitle: 18,
    title: 24,
    heading: 32,
  },

  radius: {
    sm: 6,
    md: 10,
    lg: 16,
    xl: 24,
    full: 999,
  },

  layout: {
    screen: {
      flex: 1,
      backgroundColor: "#F5F7F6",
    },
    content: {
      flexGrow: 1,
      justifyContent: "center" as const,
      padding: 24,
    },
  },
};
